package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.erxue.po.Comment;
import net.erxue.po.CommentCustom;
import net.erxue.po.User;
import net.erxue.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentsController {
	
	@Autowired
	private CommentService commentService;
	/**
	 * 添加评论
	 * /user/addComment.action
	 * http方法：post
	 * @param comment(content ,diseaseId)
	 * @return true/false
	 */
	@RequestMapping(value="/user/addComment.action",method=RequestMethod.POST)
	public @ResponseBody boolean addComment(Comment comment,HttpSession session){
		
		User user = (User) session.getAttribute("user");
		
		if(user==null){
			return false;
		}else{
			comment.setUid(user.getUid());
			try {
				if(commentService.addComment(comment)!=0){
					return true;
				}else{
					return false;
				}
			} catch (Exception e) {
				System.out.println("添加评论出错了");
				return false;
			}
		}
		
	}
	
	/**
	 * 查询所有评论
	 * findAllComments.action
	 * http方法：get
	 * @return 
	 */
	@RequestMapping(value="/findAllComments.action" ,method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public @ResponseBody List<CommentCustom> findAllComments(){
		
		List<CommentCustom> list = null;
		try {
			list=commentService.findAllComment();
		} catch (Exception e) {
			System.out.println("查询所有穴位出错了");
			return null;
		}
		return list;
		
	}
	
	/**
	 * 查看我的所有评论
	 * findMyComments.action
	 * @return
	 */
	@RequestMapping(value="/user/findMyComments.action" ,method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
	public @ResponseBody List<CommentCustom> findMyComments(HttpSession session){
		//User user = (User) session.getAttribute("user");
		//TODO 
		User user = new User();
		user.setUid(7);
		List<CommentCustom> list = null;
		try {
			list=commentService.findMyComments(user);
		} catch (Exception e) {
			System.out.println("查询我的评论出错了");
			return null;
		}
		return list;
		
	}
	
	
	
	
	/**
	 * 删除评论
	 * deleteCommentById.action
	 * @param cid
	 * @return true/false
	 */
	@RequestMapping(value="/admin/deleteCommentById.action",method=RequestMethod.GET)
	public @ResponseBody boolean deleteCommentById(@RequestParam(value="cid",required=true)Integer cid){
		try {
			if(commentService.deleteCommentById(cid)!=0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
}
