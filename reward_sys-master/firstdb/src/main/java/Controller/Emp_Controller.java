package com.example.reward_system.Controller;
import com.example.reward_system.Model.Hr_view;
import com.example.reward_system.Repository.Hrview_Repo;
import com.example.reward_system.Model.Emp_Desig;
import com.example.reward_system.Model.proposer;
import com.example.reward_system.Repository.Desig_Repo;
import com.example.reward_system.Repository.Emp_Repo;
import jdbc.Desig_Repo;
import jdbc.emp_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/reward_sy")
public class Emp_Controller {

    @Autowired
    emp_repo erepo;
    Desig_Repo drepo;
    Hrview_Repo hrepo;

    //    @RequestMapping(value = "",method= RequestMethod.GET)
//    public List<Emp_Details> getAll(){
//        return erepo.findAll();
//
//    }
    @RequestMapping(value = "/prposer",method = RequestMethod.GET)
    public String createdetail(@RequestBody proposer emp, HttpServletRequest request, HttpServletResponse response) throws JSONException {
        Emp_Desig res = drepo.findByEmailAddress(emp);
        JSONObject js = new JSONObject();
//        System.out.println(res);
        int eid = res.getEmp_id();
        int mid = res.getManager_id();
        emp.setRecipient_Id(eid);
        emp.setManager_id(mid);
        System.out.println(mid);
//        erepo.save(emp);
    }
    @RequestMapping(value= "/approval/{id}",method =RequestMethod.GET)
    public String GiveToManagerDetail(@PathVariable("id") int id, HttpServletRequest request) throws JSONException {
        List<proposer> res = erepo.findUnderManager(id);
        System.out.println(res);
        Gson gson = new Gson();
        String jsonlist = gson.toJson(res);
//        System.out.println(jsonlist);

        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray(jsonlist.trim());
//        System.out.println(jsonarray);
        for(int i=0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            JSONObject aux = new JSONObject();

            String proposer_email = jsonobject.getString("proposer_email");
            String Recipient_Email = jsonobject.getInt("recipient_email");
            String salutation = jsonobject.getString("salutation");
            int recipient_Id = jsonobject.getInt("Recipient_Id");
            int manager_id = jsonobject.getInt("manager_id");
            int status = jsonobject.getInt("status");
            String Proposal_Date = jsonobject.getString("Proposal_Date");

            aux.put("recipient_email",Recipient_Email);
            aux.put("salutation",salutation);
            aux.put("Recipient_Id",recipient_Id);
            aux.put("manager_id",manager_id);
            aux.put("status",status);
            aux.put("Proposal_Date",Proposal_Date);

            json.put(proposer_email,aux);
        }
        return (json);
    }
    @RequestMapping(value= "approval/update",method =RequestMethod.POST)
    public void UpdateDetail(@RequestBody proposer e,HttpServletRequest request,HttpServletRequest response) throws ParseException {
        proposer emp = erepo.findByRowId(e.getRow_id());
        Hr_view hr = new Hr_view();

        String manager_mail = drepo.findManEmail(emp.getManager_id());
        int flag=e.getStatus();

        emp.setStatus(flag);
        erepo.save(emp);

        String sDate1="2019-05-23";
        Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(sDate1);
//        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if (flag==1){
            hr.setApproved_date(date1);
            hr.setApprover_email(manager_mail);
            hr.setRecipient_email(emp.getRecipient_email());
            hr.setSalutation(emp.getSalutation());
            hr.setProposer_email(emp.getProposer_email());
            hr.setStatus(flag);
            hrepo.save(hr);
        }

    }

    @RequestMapping(value= "hrview/update",method =RequestMethod.GET)
    public void UpdateDetail(@RequestBody Hr_view hr,@PathVariable("flag") int flag,HttpServletRequest request,HttpServletRequest response){
        Hr_view update_hr = hrepo.findByRowId(hr.getRow_id());
        update_hr.setStatus(hr.getStatus());
        hrepo.save(update_hr);
    }

    @RequestMapping(value="hrview",method=RequestMethod.GET)
    public JSONObject GiveHrDetail(HttpServletRequest request) throws JSONException {
        String jsonlist = gson.toJson(hrepo.findAll());

        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray(jsonlist);
        for (int i = 0; i < jsonarray.length(); i++){
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            JSONObject aux = new JSONObject();

            int row_id = jsonobject.getInt("row_id");
            String recipient_email = jsonobject.getString("recipient_email");
            String proposer_email =  jsonobject.getString("proposer_email");
            String approver_email = jsonobject.getString("approver_email");
            String approved_date = jsonobject.getString("approved_date");
            String salutation = jsonobject.getString("salutation");
            int status = jsonobject.getInt("status");

            aux.put("row_id",row_id);
            aux.put("recipient_email",recipient_email);
            aux.put("proposer_email",proposer_email);
            aux.put("approver_email",approver_email);
            aux.put("approved_date",approved_date);
            aux.put("salutation",salutation);
//                System.out.println(aux);

            json.put(String.valueOf(status),aux);
        }
        System.out.println(json.toString());
        return(json);
    }

}
