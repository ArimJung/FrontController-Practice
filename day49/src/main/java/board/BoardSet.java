package board;

import java.util.ArrayList;

public class BoardSet {
	// ★★★★★
   // 글 1개 + 댓글 N개
   // java에서 로직적으로 사용할 vo를 자체제작!
	
   private BoardVO boardVO;
   private ArrayList<ReplyVO> rList =new ArrayList<ReplyVO>();
   
   public BoardVO getBoardVO() {
      return boardVO;
   }
   public void setBoardVO(BoardVO boardVO) {
      this.boardVO = boardVO;
   }
   public ArrayList<ReplyVO> getrList() {
      return rList;
   }
   public void setrList(ArrayList<ReplyVO> rList) {
      this.rList = rList;
   }
}