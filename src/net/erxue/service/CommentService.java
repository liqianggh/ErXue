package net.erxue.service;

import java.util.List;

import net.erxue.po.Comment;
import net.erxue.po.CommentCustom;
import net.erxue.po.User;

public interface CommentService {
	
	public int deleteCommentById(Integer cid);
	public int addComment(Comment comment);
	public List<CommentCustom> findAllComment();
	public List<CommentCustom> findMyComments(User user);
}
