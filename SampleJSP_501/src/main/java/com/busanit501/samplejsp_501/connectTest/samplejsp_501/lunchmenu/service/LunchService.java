package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.service;


import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.LunchVO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dao.LunchmenuDAO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dto.LunchDTO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum LunchService {
    INSTANCE;

    //준비물), 1) TodoDAO ,인스턴슨 필요
    // 2) DTO <-> VO 간에 변환기 필요, MapperUtil
    private LunchmenuDAO lunchmenuDAO;
    private ModelMapper modelMapper;

    //TodoService, 생성자 만들기.
    LunchService() {
        lunchmenuDAO = new LunchmenuDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //test
    // 쓰기, 오전에 작업한 모델은 TodoVO,
    // 지금 모델 타입 TodoDTO 을 받아서, 작업 하기 위해서, VO로 변환.
    // modelMapper 이용할 예정.
    // 작성한 데이터의 내용을 담을 임시 모델.TodoDTO
    public void register2(LunchDTO lunchDTO) throws Exception {
        // DTO -> VO 변환 이 필요함. , 도구 이용법.
        LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);
        // 수동으로 한다면,
//    TodoVO todoVO1 = TodoVO.builder()
//        .tno(todoDTO.getTno())
//        .title(todoDTO.getTitle())
//        .dueDate(todoDTO.getDueDate())
//        .finished(todoDTO.isFinished())
//        .build();
//    System.out.println("todoVO : "+ todoVO);

        // 실제 디비에도 넣기.
        lunchmenuDAO.insert(lunchVO);
    }
    // 전체 조회
    public List<LunchDTO> listAll() throws Exception {
        // DB -> DAO -> TodoVO -> TodoDTO , 변환.
        // DB : 모델 : TodoVO
        // 화면 : 모델 : TodoDTO
        List<LunchVO> sampleList = lunchmenuDAO.selectAll();
        List<LunchDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,LunchDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;
    }

    // 하나 조회
    public LunchDTO getSelectOne(Long tno) throws Exception {
        LunchVO sample = lunchmenuDAO.selectOne(tno);
//    log.info("TodoService , 확인1, sample : " + sample);
        LunchDTO lunchDTO = modelMapper.map(sample, LunchDTO.class);
        return lunchDTO;
    }


    // 수정
    // 화면에서 데이터를 넘겨받아서, DTO 담아서, 여기에 왔음.
    // todoDTO 변경할 데이터가 담겨져 있다.
    public void updateTodo(LunchDTO lunchDTO) throws Exception {
        LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);


        // 실제 디비에도 수정.
        lunchmenuDAO.update(lunchVO);
    }

    // 삭제
    public void deleteTodo(Long menuNo) throws Exception {
        lunchmenuDAO.delete(menuNo);
    }


//    public void register(LunchDTO dto) {
//        System.out.println("debug register dto 확인중 : " + dto);
//    }
//
//
//    public List<TodoDTO> getList() {
//        List<LunchDTO> listSample = IntStream.range(0, 10).mapToObj(i -> {
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long) i);
//            dto.setTitle("Sample Todo Title " + i);
//            dto.setDueDate(LocalDate.now());
//            return dto;
//        }).collect(Collectors.toList());
//        return listSample;
//    }
//
//    public List<TodoDTO> getList2() {
//        List<TodoDTO> sampleList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long) i);
//            dto.setTitle("Sample Todo" + i);
//            dto.setDueDate(LocalDate.now());
//            sampleList.add(dto);
//        }
//        return sampleList;
//    }
//    // 수정
//
//    // 삭제
//
//
//
//
//    public void register(TodoDTO dto) {
//        System.out.println("debug register dto 확인중 : " + dto);
//    }
//
//
//    public List<TodoDTO> getList() {
//        List<TodoDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long)i);
//            dto.setTitle("Sample Todo Title " + i);
//            dto.setDueDate(LocalDate.now());
//            return dto;
//        }).collect(Collectors.toList());
//        return listSample;
//    }
//
//    public List<TodoDTO> getList2() {
//        List<TodoDTO> sampleList = new ArrayList<>();
//        for (int i = 0; i <10; i++) {
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long)i);
//            dto.setTitle("Sample Todo" + i);
//            dto.setDueDate(LocalDate.now());
//            sampleList.add(dto);
//        }
//        return sampleList;
//    }

}