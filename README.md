## 스프링 게시판 프로젝트 (Spring Board Project)
##
### 프로젝트 목적

<pre><code>- 개발환경세팅부터 게시판 기능 구현을 목표로 한다.
- 우선 기본 기능들을 구현해보고, 효율적이 코딩을 위해 계속 고민하고, 리펙토링 할 생각이다.

- 화면 디자인은 시맨틱 UI를 이용하여 심플하게 구성
- 여러 게시판을 통합할 수 있도록 DB설계를 해보려고 함
</code></pre>
##
### 개발 환경

<pre><code>- Java 1.6
- Spring 3.0.7
- Maven 3.3.9
- Semantic UI
- MySql, iBatis
- Eclipse
- Tomcat 6.0.35
</code></pre>
##
### commit log

<pre><code>2018-10-24 project default setting (spring, logback, semantic ui)

 - 스프링 개발환경 세팅
 - logback 설치
 - 시맨틱 UI 설치
 - 화면 개발(메인, 헤더, 게시판 리스트)
 
2018-11-08 DataSource, iBatis config

 - 테이블 생성
  = BOARD_MASTER      -- 게시판 마스터 정보
  = BOARD_LIST        -- 게시글 리스트
  = BOARD_HIERARCHY   -- 게시글 계층구조
 
 - 데이터소스, iBatis 세팅
 
</code></pre>
