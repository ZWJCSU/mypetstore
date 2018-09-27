package org.csu.mypetstore.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private AccountService accountService;
    @RequestMapping("/Account/Login")
    public JSONArray AccountLogin(HttpServletRequest httpServletRequest){
        String username=httpServletRequest.getParameter("username");
        String password=httpServletRequest.getParameter("password");
        Account account=accountService.getAccount(username, password);
        JSONArray json = JSONArray.fromObject(account);
        return json;

    }
}
