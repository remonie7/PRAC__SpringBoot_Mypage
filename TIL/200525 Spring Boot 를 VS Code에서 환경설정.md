# Spring Boot 를 VS Code에서 환경설정

## 개요

- 왜 STS 대신 VS Code를 사용하는가? 
  - STS보다 VS Code가 가볍고 확장성도 뛰어나다. 왜냐하면 extension을 통해 라이브러리를 직접 다운받을 수 있을 뿐 아니라 자동 완성 등 편리한 기능 제공하기 때문이다.

## 설치

![001](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\001.jpg)

> jdk와 vs code를 설치 후, 환경변수 설정해주기
>
> ![캡2](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\002.jpg)
>
> ![003](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\003.jpg)
>
> ![004](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\004.jpg)
>
> CLASSPATH는 VS Code에서 자바 사용하기 위함



## VS Code

1. extensions에서 **Java Extension Pack**, **Spring Boot Extension Pack**, **Beauty** 설치

![005](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\005.jpg)



2. File -> Preferences -> Settings 들어가서 jdk 검색 후, Edit in settings.json 클릭

![006](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\006.jpg)

![007](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\007.jpg)

```JSON
{
    "java.home": "C:\\Program Files\\Java\\jdk-11.0.7",
    "editor.suggestSelection": "first",
    "vsintellicode.modify.editor.suggestSelection": "automaticallyOverrodeDefaultValue"
}
```



3. Spring 구조 만들기

>https://start.spring.io/ 
>
>![spring start](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\spring start.jpg)
>
>위와 같이 설정 후 GENERATE 눌러 저장. (여기서 메이븐은 빌드 자동화 툴)
>
>바탕화면에 project 폴더 만들고, 그 안에 압축 풀어줌
>
>![008](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\008.PNG)
>
>해당 폴더를 VS code 에서 오픈
>
>![009](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\009.PNG)
>
>pom.xml 열어 버전 확인



4. ResponseBody 어노테이션 사용해 웹 페이지 띄우기 테스트



![010](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\010.PNG)

> - src/main/java/com/mypage/blog 안의 BlogApplication.java 파일은 내 어플을 실행시키기 위한 곳
>
> - src/main/java/com/mypage/blog 밑에 controller 폴더 생성 후, 그 밑에 MainController.java 파일 생성 (자바 파일 맨 처음 대문자)

![011](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\011.PNG)

> 어노테이션
>
> - @Controller은 mvc 중 컨트롤러임을 명시
>
> - @RequestMapping은 url을 컨트롤러에 매핑 해주는 역할
>   - value는 요청된 url로 보면 됨. 
> - @ResponseBody는, html이나 jsp 파일을 받는게 아닌, 문자열 자체를 받아 페이지에 리턴한다. 이 어노테이션이 없으면 test.jsp 파일을 리턴하게 되는 것이고, 이 어노테이션이 있으면 test 문자 자체를 페이지에 띄우게 되는 것이다.

> MainController.java 파일을 저장하고, BlogApplication.java 파일로 가서 Run을 누른다.
>
> ![012](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\012.PNG)



> ![013](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\013.PNG)
>
> localhost:8080 들어가면 test가 뜨는 것을 볼 수 있다.
>
> ![014](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\014.PNG)
>
> localhost:8080/sh 으로 들어가면 shtest가 정상적으로 뜨는 것을 볼 수 있다.



5. @ResponseBody를 쓰지 않고, jsp 파일을 리턴받아 페이지에 띄우는 방법은 다음과 같다.

>![015](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\015.PNG)
>
>우선 MainController.java 파일이다. @ResponseBody가 사라지고 public이 생긴 것을 볼 수 있다.
>
>또, jsp 파일의 구동을 위해 pom.xml 파일에 추가해주어야 할 부분이 있다.
>
>![016](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\016.PNG)
>
>jasper, jstl을 의존성에 추가해주어야 한다. (https://mvnrepository.com/) 에서 검색해서 복붙하면 됨. 코드 복붙 하려면 아래에.
>
>```xml
>	<!-- jsp -->
>	<dependency>
>		<groupId>org.apache.tomcat.embed</groupId>
>		<artifactId>tomcat-embed-jasper</artifactId>
>		<scope>provided</scope>
>	</dependency>
>
>	<dependency>
>		<groupId>javax.servlet</groupId>
>		<artifactId>jstl</artifactId>
>	</dependency>
>
>	<!-- jsp -->
>```
>
>
>
>
>
>다음은 src/main/resources/application.properties 파일을 열어준다.
>
>![017](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\017.PNG)
>
>- prefix는 컨트롤러에서 리턴받은 파일명 앞에 붙여주는 접두어
>- suffix는 컨트롤러에서 리턴받은 파일명 뒤에 붙여주는 접미어
>
>src/main/resources 안에 META-INF/resources/WEB-INF/view 폴더 만들어주고, 그 안에 test.jsp 파일 만들어준다. MainController.java 에서 "test"를 리턴받았기 때문에 파일명은 test이고, application.properties에서 prefix, suffix로 접두어, 접미어를 지정해줬으므로 경로와 파일 확장명은 위와 같다.
>
>![018](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\018.PNG)
>
>test.jsp는 다음과 같다. "우왕성공!!"이 페이지에 띄워지면 성공이다!! 아직 jsp 서툰 경우 아래 복붙해서 해보자.
>
>```jsp
><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
><%@ page session="false" %>
><!DOCTYPE html>
><html lang="ko">
>    <head>
>        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
>            <title>View Test Page</title>
>        </head>
>        <body>
>            <h1>우왕성공!!</h1>
>        </body>
>    </html>
>```
>
>
>
>저장한 후 BlogApplication.java 로 가서 run!
>
>![012](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\012.PNG)
>
>localhost:8080 들어가면 우왕성공이!!
>
>![019](C:\Users\remon\Desktop\SpringBoot_Mypage\capture\019.PNG)

