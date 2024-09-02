package org.sellers.controller;

import org.sellers.domain.TExample;
import org.sellers.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    /**
     * 利用rabbitmq和重定向新增数据，外加spring mvc文件上传
     *
     * @param request
     * @param response
     * @param images
     * @throws IOException
     * @throws ServletException
     */
    //MultipartFile名字必须和表单文件上传项名称一样
    @RequestMapping(value = "rabbitInsert", method = RequestMethod.POST)
    public void insertOnRabbit(String exampleName, String exampleDesc, HttpServletRequest request, HttpServletResponse response, MultipartFile images) throws IOException {
        TExample example = new TExample();
        example.setExampleName(exampleName);
        example.setExampleDesc(exampleDesc);
        //指定文件上传的位置
        String path = request.getSession().getServletContext().getRealPath("/static/images");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();//判断该文件夹是否存在，不存在则新建一个
        }
        String fileName = images.getOriginalFilename();//获取需要上传文件的名称
        if (fileName == null) throw new AssertionError();
        images.transferTo(new File(path, fileName));//完成文件上传
        example.setInsertTime(new Timestamp(System.currentTimeMillis()));
        example.setImages(fileName);
        exampleService.insertExampleInRabbit(example);
        //request.getRequestDispatcher("templates/insertRabbitSuccess.html").forward(request,response);//请求转发
        //response.sendRedirect(request.getContextPath()+"templates/insertRabbitSuccess.html");//重定向 两次请求
        response.sendRedirect(request.getContextPath() + "/example/selectAll");
    }

    @RequestMapping("/selectAll")
    public String selectAllExample(Model model) {
        List<TExample> exampleList = exampleService.selectAllExample();
        model.addAttribute("exampleList", exampleList);
        return "insertRabbitSuccess";
    }
}
