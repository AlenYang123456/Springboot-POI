package net.general.aggregation.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: dreamer Q
 * @Date: 2019/11/26 20:48
 * @Version 1.0
 * @Discription
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestLocalDateTimeVO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime localDateTime;
}
