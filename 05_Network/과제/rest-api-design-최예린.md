
*  기본 기능
    1. `GET /lists/{categoryName}/1`

    ```json
    {
        "page": "1",
        "listSize": "20", 
        "maxListSize" : "20",
        "lists": [ {
            "articleId" : "1",
            "articleTitle" : "게시글 작성1",
            "writer" : "사용자1",
            "modifiers" : [ {
                "modifier": "사용자24",
                "modifier": "사용자1"
            } ],
            "uploadDate" : "2022-10-18 12:02:124",
            "commentsCnt" : "24"
        } ,
        ...
        {
            "articleId" : "20",
            "articleTitle" : "게시글 작성20",
            "writer" : "사용자18",
            "modifiers" : [ {
                "modifier": "사용자2",
                "modifier": "사용자13"
            } ],
            "uploadDate" : "2022-10-01 15:14:352",
            "commentsCnt" : "103"
        } ]
    }
    ```

    2. ` GET       /articles/ {articleId}`         // 특정 카테고리의 게시글
    ```json
    {
        "articleId": "1",
        "articleTitle": "게시글 작성1", 
        "content" : "게시글 내용이 이어질 예정입니다.......였습니다.",
        "writer" : "사용자1",
        "modifier" : [ {
            "modifier": "사용자24",
            "modifier": "사용자1"
        } ],
        "uploadDate" : "2022-10-18 12:02:124",
        "modifiedDates" : [ {
            "modifiedDate": "2022-10-19 22:12:322",
            "modifiedDate": "2022-10-20 23:18:812"
        } ],
        "commentsCnt" : "24",
        "comments": [ {
            "commentId" : "1",
            "commentContent" : "좋은 글인것 같아요.",
            "commentWriter" : "사용자5",
            "commentDate" : "2022-10-20 13:30:243"
        } ,
        ...
        {
            "commentId" : "24",
            "commentContent" : "무슨 내용인지 이해가 안가네요",
            "commentWriter" : "사용자3",
            "commentDate" : "2022-10-21 12:19:243"
        } ]
    }
    ```
        
    3. ` POST      /write                              ? login=ok`

    4. ` PATCH     /user/articles/{articleId}`

    5. ` DELETE    /user/articles/{articleId}`            

    6. ` PATCH     /admin/articles/{articleId}`       

    7. ` DELETE    /admin/articles/{articleId}`      

    8. ` POST      /admin/garbages/{garageNum}`                

    9. ` POST      /articles/{articleId}/comment      ? login=ok`

    ```json
    1. 댓글이 없는 경우 응답
    {
        "error_code": "COMMENTS_NOT_FOUND"
    }
    2. 없는 게시글 번호인 경우 응답
    {
        "error_code": "ARTITLES_NOT_FOUND"
    }
    3. 권한이 없는 게시글 번호인 경우 응답
    {
       "error_code": "NO_AUTHORITY_TO_ACCESS"
    }
    ```

* 추가 기능 1
  1. `POST      /articles/{articleId}/like         ? login=ok`
  2. `PATCH     /articles/{articleId}/like         ? login=ok`

* 추가 기능 2
  1. `POST      /articles/{articleId}/reply        ? login=ok`
  2. `POST      /articles/{articleId}/replies/level? login=ok`

* 추가 기능 3
  1. `GET       /lists/like/articles                ? login=ok`
  ```json
    {
        "page": "1",
        "listSize": "20", 
        "maxListSize" : "20",
        "likeLists": [ {
            "articleId" : "1",
            "articleTitle" : "게시글 작성1",
            "writer" : "사용자1",
            "modifiers" : [ {
                "modifier": "사용자24",
                "modifier": "사용자1"
            } ],
            "uploadDate" : "2022-10-18 12:02:124",
            "commentsCnt" : "24"
        } ,
        {
            "articleId" : "15",
            "articleTitle" : "게시글 작성15",
            "writer" : "사용자3",
            "modifiers" : [ {
            } ],
            "uploadDate" : "2022-10-11 11:17:873",
            "commentsCnt" : "4"
        } ]
    }
    ```

  2. `GET       /search                             ? title={articleTitle}`
  ```json
    {
        "page": "1",
        "listSize": "20", 
        "maxListSize" : "20",
        "searchTitle" : "게시글1",
        "searchLists": [ {
            "articleId" : "1",
            "articleTitle" : "게시글 작성1",
            "writer" : "사용자1",
            "modifiers" : [ {
                "modifier": "사용자24",
                "modifier": "사용자1"
            } ],
            "uploadDate" : "2022-10-18 12:02:124",
            "commentsCnt" : "24"
        } ,
        "searchLists": [ {
            "articleId" : "1",
            "articleTitle" : "게시글 작성11",
            "writer" : "사용자7",
            "modifiers" : [ {
            } ],
            "uploadDate" : "2022-10-15 10:42:244",
            "commentsCnt" : "67"
        } ,
        
    }
    ```

-  더 생각해 본다면, 
1. 게시글에 목록에 정렬 기능을 제공한다면, 어떻게 제공할 수 있을까요?
    > GET lists/all?sort=desc
    
   -  위와 같이쿼리문을 추가하여 정렬내용을 추가해도 좋을 것 같습니다.

2.  게시판이 여러개가 있다면 어떤 URL 구조여야 할까요?
    > GET lists/{categoryName}
    
    - 이전에 언급했던 바와 같이 전체 게시글이 아닌경우 lists하위에 카테고리 명을 작성하여 구분한다.

3.  임시보관함이 있고 이어 쓸 수 있으려면 어떻게 해야할까요? 
    > GET user/tempos/{tempoNum}

    - 위와 같이 user안에 articles와 tempos 카테고리를 나눠 해당 파일을 작성하면 tempos에서 articles로 이동하게 하면 될 것 같다.

4.  임시보관된 게시글은 최종적으로 다른 게시판에 등록할 수 있다면 어떻게 해야할까요?
    > POST /write/{tempoNum}

    - write에 articleNum이나 tempoNum과 같이 고유 값을 추가하여 기존 데이터를 불러와 작성 시 이어 쓸 수 있게 해주고 write로 작성 시 다른 게시글에 등록될 것입니다. 
    - write 작성 페이지에 따로 카테고리 옵션을 작성하게 하여 카테고리 정보를 등록하면 전체 또는 해당 카테고리에서 볼 수 있을 것 같습니다.  

5.  게시글이 여러 게시판에서 볼 수 있게 정의가 되면 URL 경로가 어떻게 되어야 할까요?
    > GET /articles/{articleId}

    - 게시글을 볼 때 /articles/{articleId}만 url 경로에 추가해뒀기에 여러 게시판에서 볼 수 있게 정의가 되어도 특정 카테고리명을 기입할 필요가 없기에 상관이 없을 것 같습니다.
    - 대신에 게시글 목록 정보에 카테고리리스트를 추가하여 나중에 검색할 때 특정짓게 합니다.

6.  특정 게시판의 글을 다른 게시판으로 옮기려면 어떻게 해야할까요?
    > POST /write/{articleId}?login=ok

    - 게시글을 수정할때 articleId로 데이터를 가져와 카테고리를 변경하여 다시 write를 한다면 POST를 통해 정보가 수정될 것이다.

7.  파일 업로드는 어떤 경로로 만드는 것이 좋을까요?
    > https://user-files.com/{userHashCode}/images/{파일업로드위치-파일명.파일확장자}
    
    - 사용자 아이디와 파일 종류와 관련한 경로를 만드는 것이 좋을것 같습니다.
    

8.  API 버전을 표시해야 한다면 어떻게 하는 것이 좋을까요? 

    - 버전업데이트 범위에 따라 API v1, API v1.1, API v2 등으로 정하면 될 것 같다.

9.  에러는 어떻게 표현하는 것이 좋을까요?

    - 웹서비스의 경우 경고창을 지원해주는 브라우저의 경우 경고창을 띄워 에러를 표시 후 이전 화면으로 돌아가는 것이 좋을 것 같습니다.

10. 게시물의 조회수가 올라가야 한다면, 어떻게 설계하면 좋을까요?

    - GET 방식에 쿼리문을 추가하여 조회수를 증가시키는 방법을 생각해보았습니다.

    