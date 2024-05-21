package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dao;

import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.LunchVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LunchmenuDAO {

    public List<LunchVO> selectAll() throws Exception{

        String sql = "select * from lunchmenu";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();

        List<LunchVO> samples = new ArrayList<LunchVO>();

        while (resultSet.next()){
//
            LunchVO lunchVOBuilder = LunchVO.builder()
                    .menuNo(resultSet.getLong("menuNo"))
                    .menuTitle(resultSet.getString("MenuTitle"))
                    .menuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                    .build();
            // 리스트에 담기.
            samples.add(lunchVOBuilder);
        }

        //임시 반환값.
        return samples;
    }
//select one
    public LunchVO selectOne(Long menuNo) throws Exception{
        String sql = "select * from lunchmenu where menuNo = ?";

        @Cleanup Connection conn = com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1,menuNo);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 값이 하나여서, 반복문 필요없음.
        resultSet.next();
        // 임시 로 담을 인스턴스 . builder 패턴 이용해보기.
        // 데이터베이스에서 조회한 1개의 행을 넣기.
        LunchVO lunchVOBuilder = LunchVO.builder()
                .menuNo(resultSet.getLong("menuNo"))
                .menuTitle(resultSet.getString("MenuTitle"))
                .menuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                .build();
        // 임시 인스턴스
        return lunchVOBuilder;
    }

    // 쓰기 insert

    public void insert(LunchVO vo) throws Exception {
        String sql = "insert into lunchmenu (MenuTitle, MenuRegDate) values (?,?);";

        @Cleanup Connection conn = com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,vo.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(vo.getMenuRegDate()));


        pstmt.executeUpdate();
    }

    // 수정 update

    public void update(LunchVO vo) throws Exception {
        String sql = "update lunchmenu set MenuTitle = ?, MenuRegDate = ? " +
                "where menuNo = ?;";

        @Cleanup Connection conn = com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,vo.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(vo.getMenuRegDate()));
        pstmt.setLong(3,vo.getMenuNo());

        pstmt.executeUpdate();
    }

    // 삭제 delete
    public void delete(long menuNo) throws Exception {
        String sql = "delete from lunchmenu where menuNo = ?;";

        @Cleanup Connection conn = com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1,menuNo);
        pstmt.executeUpdate();
    }


    public String  getTime2() throws Exception{
        // 자원 반납 자동으로 처리해보기, 롬복의 @Cleanup 기능 이용하기.
        //사용법 : @Cleanup , 자동으로 반납 하고 싶은 메서드에 붙이기.
        @Cleanup Connection connection = com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }
    // 데이터베이스 직접적인 비지니스 로직 처리하는 기능을 만들기.
    // 샘플
    // 현재 시간을 가져오는 기능.
    public String getTime() {
        // HikariCP 이용해서, 디비 연결하는 도구 Connection  타입의 인스턴스 만들기.
        // 사용법.
//    Connection conn = ConnectionUtil.INSTANCE.getConnection();
        // 디비에 접근 하려면, 반드시 예외 처리를 해야함.
        // 3가지 방법. 1) try catch finally 2) throws 3) try resources with (자동 close)
        // 결론, 롬복의 @cleanup , 자동으로 반납함.

        // 예시 try with resources  (자동 close)
        String now = null;
        // 디비 연결해서, 시각 가져오는 코드.
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            // sql 전달하는 도구.
            // String sql = "select now()"
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            // 조회한 결과 테이블을 담기위한 임시 테이블
            // 0 행부터 대기중.
            ResultSet rs = pstmt.executeQuery();
        ){
            // 1행 만 있어서, while 문 없음.
            rs.next();
            // 1행의 결과를 가져오기. 문자열
            now = rs.getString(1);
        } catch (Exception exception) {
            exception.printStackTrace();
        } //원래는 finally 구문으로 close 해야하지만,
        // try resource , 자동 close 가 포함되어 있다.
        return now;
    }
}