package net.erxue.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import net.erxue.mapper.CommentMapper;
import net.erxue.po.Comment;
import net.erxue.po.CommentCustom;
import net.erxue.po.User;
import net.erxue.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public int deleteCommentById(Integer cid) {
		return commentMapper.deleteCommentById(cid);
	}

	@Override
	public int addComment(Comment comment) {
		return commentMapper.addComment(comment);
	}

	@Override
	public List<CommentCustom> findAllComment() {
		List<CommentCustom> list = commentMapper.findAllComments();
//		Calendar cal = Calendar.getInstance();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		for(CommentCustom comment:list){
//			cal.setTime(comment.getCreateTime());
			String str = sdf.format(comment.getCreateTime());
			comment.setTime(str);
		}
		
		return list;
	}

	//查询我所参与的评论
	@Override
	public List<CommentCustom> findMyComments(User user) {
		List<CommentCustom> list = commentMapper.findMyComments(user);
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		for(CommentCustom comment:list){
//			cal.setTime(comment.getCreateTime());
			String str = sdf.format(comment.getCreateTime());
			comment.setTime(str);
		}
		return list;
	}

}
