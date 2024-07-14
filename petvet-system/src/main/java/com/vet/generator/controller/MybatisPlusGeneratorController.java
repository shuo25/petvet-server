package com.vet.generator.controller;

import com.vet.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * mybatisPlus代码生成器
 * Author: 18615
 * Date: 2024/7/14 下午9:05
 */
@RestController
@RequestMapping("/generator")
@RefreshScope
public class MybatisPlusGeneratorController {

    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;
    @Value("${mybatis-plus.global-config.db-config.logic-delete-field}")
    private String logicDeleteField;

    /**
     * 生成表代码
     * @param path 生成文件路径
     * @param moduleName 模块名称
     * @param tableName 表名
     * @param tablePrefix 过滤的表名前缀
     * */
    @GetMapping("/table")
    public ResultData<String> generatorData(@RequestParam(name = "path", required = true) String path,
                                            @RequestParam(name = "moduleName", required = true) String moduleName,
                                            @RequestParam(name = "tableName", required = true) String tableName,
                                            @RequestParam(name = "tablePrefix", required = true) String tablePrefix) {
        FastAutoGenerator.create(url, username, password)
                //1.全局配置
                .globalConfig(builder -> {
                    builder.author("petvet")
                            .outputDir(path + "\\src\\main\\java") // 设置生成路径
                            .dateType(DateType.ONLY_DATE);
                })
                //2.包的配置
                .packageConfig(builder -> {
                    builder.moduleName(moduleName)
                            .parent("com.vet")
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller");
                })
                //3.策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置要映射的表
                            .addTablePrefix(tablePrefix)  // 设置过滤表前缀
                            .entityBuilder().enableLombok() // 自动lombok
                            .idType(IdType.ASSIGN_ID) //全局主键策略
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .logicDeletePropertyName(logicDeleteField)
                    ;  // 逻辑删除
                    builder.mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .build();
                })
                //4.Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
        return ResultData.success("生成成功！");
    }
}
