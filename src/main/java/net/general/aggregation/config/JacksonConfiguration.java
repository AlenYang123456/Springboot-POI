//package net.general.aggregation.config;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.convert.converter.Converter;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
///**
// * @Author: dreamer Q
// * @Date: 2019/11/1 14:54
// * @Version 1.0
// * @Discription 时间日期转换器 备注 2019/11/26 晚上9点已确认没用
// */
//@Configuration
//public class JacksonConfiguration {
//
//
//    /** 默认日期时间格式 */
//    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd-HH:mm:ss";
//    /** 默认日期格式 */
//    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
//    /** 默认时间格式 */
//    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
//
//
//    /**
//     * LocalDate转换器,用于转换RequestParam和PathVariable参数
//     *
//     * @return
//     */
//    @Bean
//    public Converter<String, LocalDate> localDataConverter() {
//        return new Converter<String, LocalDate>() {
//            @Override
//            public LocalDate convert(String date) {
//                return LocalDate.parse(date, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
//            }
//        };
//    }
//
//    /**
//     * LocalTime转换器,用于转换RequestParam和PathVariable参数
//     *
//     * @return
//     */
//    @Bean
//    public Converter<String, LocalTime> localTimeConverter() {
//        return new Converter<String, LocalTime>() {
//            @Override
//            public LocalTime convert(String time) {
//                return LocalTime.parse(time, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
//            }
//        };
//    }
//
//    /**
//     * LocalDateTime转换器,用于转换RequestParam和PathVariable参数
//     *
//     * @return
//     */
//    @Bean
//    public Converter<String, LocalDateTime> localDateTimeConverter() {
//        return new Converter<String, LocalDateTime>() {
//            @Override
//            public LocalDateTime convert(String time) {
//                return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
//            }
//        };
//    }
//
//    /**
//     * Date转换器 用于转换RequetParam和PathVariable参数
//     *
//     * @return
//     */
//    @Bean
//    public Converter<String, Date> dateConverter() {
//        return new Converter<String, Date>() {
//            @Override
//            public Date convert(String source) {
//                SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
//                try {
//                    return format.parse(source);
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//    }
//
////    /**
////     * Json序列化和反序列化器,用于转换Post请求体中的Json以及将我们的对象序列化为返回响应的Json
////     *
////     * @return
////     */
////    @Bean
////    public ObjectMapper objectMapper() {
////        ObjectMapper objectMapper = new ObjectMapper();
////        objectMapper.disable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS);
////        objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
////        //objectMapper忽略多于的字段
////        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////
////        //LocalDateTime系列序列化和反序列化 继承自JSR310 ,我们在这里修改了日期格式
////        JavaTimeModule javaTimeModule = new JavaTimeModule();
////        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
////        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
////        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
////        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
////        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
////        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
////
////        //Date序列化和反序列化
////        javaTimeModule.addSerializer(Date.class, new JsonSerializer<Date>() {
////            @Override
////            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
////                SimpleDateFormat formatter =new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
////                String formattedDate = formatter.format(date);
////                jsonGenerator.writeString(formattedDate);
////            }
////        });
////        javaTimeModule.addDeserializer(Date.class, new JsonDeserializer<Date>() {
////            @Override
////            public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
////                SimpleDateFormat formatter =new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
////                String date = jsonParser.getText();
////                try {
////                   return formatter.parse(date);
////                } catch (ParseException e) {
////                    throw new RuntimeException(e);
////                }
////            }
////        });
////        //将Long类型转换为String类型
////        SimpleModule simpleModule =new JavaTimeModule();
////        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
////        simpleModule.addSerializer(Long.TYPE,ToStringSerializer.instance);
////
////        //注册新的模块到objectMapper
////        objectMapper.registerModules(javaTimeModule,simpleModule);
////
////        return objectMapper;
////    }
////
////    @Bean
////    @Primary
////    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
////        return builder -> builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
////                .serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
////                .serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)))
////                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
////                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
////                .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
////    }
//
//
//}
