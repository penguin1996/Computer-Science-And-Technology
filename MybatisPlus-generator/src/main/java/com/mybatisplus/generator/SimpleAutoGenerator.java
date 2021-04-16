package com.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.IConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.mybatisplus.generator.config.IConfigBuilder;
import java.io.File;
import java.util.Scanner;

/**
 * 抽象代码生成器
 *
 * @author hubin
 * @since 2021-02-08
 */
public abstract class SimpleAutoGenerator {
    /**
     * 读取控制台输入内容
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 控制台输入内容读取并打印提示信息
     *
     * @param message 提示信息
     * @return
     */
    public String scannerNext(String message) {
        System.out.println(message);
        return scanner.next();
    }

    /**
     * 执行代码生成
     */
    public void execute() {
        // 执行开始
        this.start();

        // 初始化配置数据源
        new AutoGenerator(this.configBuilder(dataSourceConfigBuilder()))
                // 全局配置
                .global(this.configBuilder(globalConfigBuilder()))
                // 模板配置
                .template(this.configBuilder(templateConfigBuilder()))
                // 包配置
                .packageInfo(this.configBuilder(packageConfigBuilder()))
                // 策略配置
                .strategy(this.configBuilder(strategyConfigBuilder()))
                // 执行
                .execute(this.templateEngine());
    }

    protected <T> T configBuilder(IConfigBuilder<T> configBuilder) {
        return null == configBuilder ? null : configBuilder.build();
    }

    /**
     * 执行开始
     */
    public void start() {
        System.out.println("！！！执行代码自动生成开始！！！");
    }

    /**
     * 数据源配置 Builder
     */
    public abstract IConfigBuilder<DataSourceConfig> dataSourceConfigBuilder();

    /**
     * 全局配置 Builder
     */
    public IConfigBuilder<GlobalConfig> globalConfigBuilder() {
        String outputDir = new File(System.getProperty("user.dir")) + File.separator + "build" + File.separator + "code";
        System.out.println("\n输出文件目录：" + outputDir);
        return new GlobalConfig.Builder().fileOverride().enableSwagger2().outputDir(outputDir)
                .author(scannerNext("\n请输入作者名称：")).dateType(DateType.ONLY_DATE);
    }

    /**
     * 生成文件包名配置 Builder
     */
    public IConfigBuilder<PackageConfig> packageConfigBuilder() {
        return new PackageConfig.Builder().parent(scannerNext("\n请输入项目包名：")).moduleName(scannerNext("\n请输入项目模块名："));
    }

    /**
     * 自定义模板配置 Builder
     */
    public IConfigBuilder<TemplateConfig> templateConfigBuilder() {
        return null;
    }

    /**
     * 代码生成策略配置 Builder
     */
    public IConfigBuilder<StrategyConfig> strategyConfigBuilder() {
        return new StrategyConfig.Builder().addInclude(scannerNext("\n请输入表名多个英文逗号分隔：").split(","))
                .entityBuilder().naming(NamingStrategy.underline_to_camel)
                .controllerBuilder().enableRestStyle().enableHyphenStyle();
    }

    /**
     * 代码生成，模板引擎
     */
    public AbstractTemplateEngine templateEngine() {
        return null;
    }
}
