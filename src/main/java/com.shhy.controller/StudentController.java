package com.shhy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shhy.domain.Student;
import com.shhy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        //使用静态方法设置初始页码数和条目数
        PageHelper.startPage(page,pageSize);
        ModelAndView modelAndView = new ModelAndView("/Student/list");
        System.out.println("StudentController的工作");
        List<Student> Students = studentService.findAll();
        //创建一个PageInfo对象,用以封装查询到的数据,同时指定页码导航列表的数目
        PageInfo pageinfo = new PageInfo(Students,5);
        //将PageInfo对象封装到模型中
        modelAndView.addObject("pageinfo", pageinfo);
        return modelAndView;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(Student Student){
        System.out.println(Student);
        Integer i = studentService.insert(Student);
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Integer id){
        Integer i = studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/findOne")
    public ModelAndView findOne(@RequestParam  Integer id){
        ModelAndView modelAndView = new ModelAndView("Student/updateForm");
        Student Student = studentService.findOne(id);
        modelAndView.addObject("Student", Student);
        return  modelAndView;
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(Student Student){
        System.out.println(Student);
        Integer i = studentService.update(Student);
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/addForm")
    public String toAddForm(){
        return "Student/addForm";
    }

    /**
     * 使用户点击后能够跳转到登录页面
     * */
    @RequestMapping(value = "/login")
    public String toLogin(){
        return "Student/login";
    }

//    @ResponseBody
//    @RequestMapping(value = "/StudentExist")
//    public String StudentExist(@RequestParam(value = "Studentname")String Studentname){
//        Student Student = StudentService.findOneByStudentname(Studentname);
//        if(Student !=null && Student.getStudentname().equals(Studentname)){//表示该用户存在
//            return "yes";
//        } else{
//            return "no";
//        }
//    }

    /**
     * 登录检查
     */
//    @RequestMapping(value = "/loginCheck")
//    public ModelAndView loginCheck(Student Student, HttpSession httpSession){
//        //将前端送入的多个字段封装为Student对象传递给service调用,返回的是数据库中的oneByStudent对象
//        Student oneByStudent = StudentService.findOneByStudent(Student);
//        ModelAndView modelAndView = new ModelAndView();
//        if(oneByStudent != null){//表示从数据库得到了数据并被封装为Student对象
//            httpSession.setAttribute("Student_SESSION",oneByStudent); //将返回的用户信息放入session对象
//            modelAndView.setViewName("redirect:/admin");//重定向到其他页面
//        }else{
//            modelAndView.setViewName("redirect:/Student/login");
//        }
//        System.out.println("用户登录检查");
//        return modelAndView;
//    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        //httpSession.setAttribute("Student_SESSION",null);//清空用户相关的session
        httpSession.invalidate();//使session失效
        //退出登录后,将页面重新定向到login
        return "redirect:/Student/login";
    }
}
