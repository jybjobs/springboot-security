# springboot
springboot 

## spring security

## spring actuator

##spring swagger2

rest api 文档添加
 １、引入ｊａｒ
 ２、在应用主类中增加　@EnableSwagger2Doc
 ３、在方法上配置
    @ApiOperation(value = "查询客户信息",notes = "根据id查询客户信息")
    @ApiImplicitParam(name = "id",value = "客户信息id",required = true,dataType = "long")
    
    说明：
    
    @Api：用在类上，说明该类的作用
    @ApiOperation：用在方法上，说明方法的作用
    @ApiImplicitParams：用在方法上包含一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
        paramType：参数放在哪个地方
            header-->请求参数的获取：@RequestHeader
            query-->请求参数的获取：@RequestParam
            path（用于restful接口）-->请求参数的获取：@PathVariable
            body（不常用）
            form（不常用）
            name：参数名
        dataType：参数类型
        required：参数是否必须传
        value：参数的意思
        defaultValue：参数的默认值
    @ApiResponses：用于表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
        code：数字，例如400
        message：信息，例如"请求参数没填好"
        response：抛出异常的类
    @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    @ApiModelProperty：描述一个model的属性
    
 ４、配置变量
   swagger.title=标题
   swagger.description=描述
   swagger.version=版本
   swagger.license=许可证
   swagger.licenseUrl=许可证URL
   swagger.termsOfServiceUrl=服务条款URL
   swagger.contact.name=维护人
   swagger.contact.url=维护人URL
   swagger.contact.email=维护人email
   swagger.base-package=swagger扫描的基础包，默认：全扫描
   swagger.base-path=需要处理的基础URL规则，默认：/**
   swagger.exclude-path=需要排除的URL规则，默认：空