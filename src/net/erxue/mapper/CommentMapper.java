package net.erxue.mapper;

import java.util.List;

import net.erxue.po.Comment;
import net.erxue.po.CommentCustom;
import net.erxue.po.User;

public interface CommentMapper {

	public  int addComment(Comment comment);
	
	public List<CommentCustom> findAllComments();
	
	
	public Integer deleteCommentById(int cid);

	public List<CommentCustom> findMyComments(User user);
	
}
