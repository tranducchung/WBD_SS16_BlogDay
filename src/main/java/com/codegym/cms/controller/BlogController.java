package com.codegym.cms.controller;
import com.codegym.cms.model.Blog;
import com.codegym.cms.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

   @GetMapping("/blogs")
    public ModelAndView showListBlog(){
       return new ModelAndView("list","blogs",blogService.findAll());
   }
   @GetMapping("/create-blog")
    public ModelAndView showWriteForm(){
       return new ModelAndView("write","blog",new Blog());
   }
   @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute Blog blog){
       blogService.save(blog);
       ModelAndView modelAndView = new ModelAndView("write");
       modelAndView.addObject("message","Add blog to list success");
       modelAndView.addObject("blog",new Blog());
       return modelAndView;
   }
   @GetMapping("/delete-blogs/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
       return new ModelAndView("delete","blog",blogService.findById(id));
   }
   @PostMapping("/delete-blogs")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirect){
       blogService.remove(blog.getId());
       redirect.addFlashAttribute("message","Delete blogs success");
       return "redirect:/blogs";
   }
   @GetMapping("/view-blogs/{id}")
    public ModelAndView showViewBlog(@PathVariable int id){
       return new ModelAndView("view","blog",blogService.findById(id));
   }
   @GetMapping("/edit-blogs/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
       return new ModelAndView("edit","blog",blogService.findById(id));
   }
   @PostMapping("/edit-blogs")
    public String editBlog(@ModelAttribute Blog blog,RedirectAttributes redirect){
       blogService.update(blog);
       redirect.addFlashAttribute("message","Edit blog success");
       return "redirect:/blogs";
   }
}
