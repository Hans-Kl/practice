package ss;

import java.util.ArrayList;

/**
 * @author klhans
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<SaveTaskRequestBaseVO> saveTaskRequestBaseVOS = new ArrayList<SaveTaskRequestBaseVO>();
        while(true){
            SaveTaskRequestBaseVO vo = new SaveTaskRequestBaseVO();
            vo.setSourceId(111L);
            vo.setSourceType("213");
            vo.setRole("asdf");
            vo.setBusinessName("asdf");
            vo.setTemplateId(0L);
            vo.setPoint(0);
            vo.setStatus(0);
            vo.setStartTime("asdf");
            vo.setEndTime("asdf");

            saveTaskRequestBaseVOS.add(vo);
        }
    }
}
