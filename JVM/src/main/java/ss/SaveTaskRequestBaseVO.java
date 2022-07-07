package ss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author linghan.kong
 * @date 2019/6/4 14:05
 * @description 业务方新建团队任务请求VO
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SaveTaskRequestBaseVO {
    private Long sourceId;

    private String sourceType;

    private String role;

    private String businessName;

    private Long templateId;


    private Integer point = 1;

    //未回复特殊字段,其他业务不允许传(问诊结论除外)
    private Integer status;

    private String startTime;

    private String endTime;

}
