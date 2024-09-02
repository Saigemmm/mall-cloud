package org.sellers.controller;

import com.github.pagehelper.PageInfo;
import org.sellers.domain.TUser;
import org.sellers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 利用ModelAndView跳转页面
     */
    @RequestMapping("/modelAndViewSelect")
    public ModelAndView selectAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<TUser> list = userService.selectAllUser();
        modelAndView.addObject("modelUser", list);//在放入modelAndView中的同时也会存到request中
        modelAndView.setViewName("modelAndViewUser");//设置跳转的页面
        return modelAndView;
    }

    /**
     * 用model对象传递参数,response跳转页面
     */
    @RequestMapping("/modelSelect")
    public void selectModelAll(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TUser> list = userService.selectAllUser();
        model.addAttribute("modelUser", list);
        response.sendRedirect(request.getContextPath() + "/user/modelAndViewSelect");//这个重定向是请求链接
    }

    /**
     * 分页查询
     */
    @RequestMapping("/pagingSelect")
    @ResponseBody
    public PageInfo<TUser> pagingSelect(int pageNum, int pageSize) {
        return userService.pagingSelectAllName(pageNum, pageSize);
    }
}
