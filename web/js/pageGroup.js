// JavaScript Document
//根据总页数判断，如果小于5页，则显示所有页数，如果大于5页，则显示5页。根据当前点击的页数生成
var flag = false;

$(function () {
    //点击分页按钮触发
    $("#list").on("click", "li", function () {
        var pageCount = $("pagecount").text();
        var pageNum = parseInt($(this).html());//获取当前页数
        if (pageCount > 5) {
            pageGroup(pageNum, pageCount);
        } else {
            $(this).addClass("on");
            $(this).siblings("li").removeClass("on");
        }
        method(pageNum);
    });

    //点击上一页触发
    $("#pageGro .pageUp").click(function () {
        var pageCount = $("#pagecount").text();
        if (pageCount > 5) {
            var pageNum = parseInt($("#pageGro li.on").html());//获取当前页
            pageUp(pageNum, pageCount);
        } else {
            var index = $("#pageGro ul li.on").index();//获取当前页
            if (index > 0) {
                $("#pageGro li").removeClass("on");//清除所有选中
                $("#pageGro ul li").eq(index - 1).addClass("on");//选中上一页
                method(index);
            }
        }
    });

    //点击下一页触发
    $("#pageGro .pageDown").click(function () {
        var pageCount = $("#pagecount").text();
        if (pageCount > 5) {
            var pageNum = parseInt($("#pageGro li.on").html());//获取当前页
            pageDown(pageNum, pageCount);
        } else {
            var index = $("#pageGro ul li.on").index();//获取当前页
            if (index + 1 < pageCount) {
                $("#pageGro li").removeClass("on");//清除所有选中
                $("#pageGro ul li").eq(index + 1).addClass("on");//选中下一页
                method(index + 2);
            }
        }
    });
});

//点击跳转页面
function pageGroup(pageNum, pageCount) {
    switch (pageNum) {
        case 1:
            page_icon(1, 5, 0);
            break;
        case 2:
            page_icon(1, 5, 1);
            break;
        case pageCount - 1:
            page_icon(pageCount - 4, pageCount, 3);
            break;
        case pageCount:
            page_icon(pageCount - 4, pageCount, 4);
            break;
        default:
            page_icon(pageNum - 2, pageNum + 2, 2);
            break;
    }
}

//根据当前选中页生成页面点击按钮
function page_icon(page, count, eq) {
    var ul_html = "";
    for (var i = page; i <= count; i++) {
        ul_html += "<li>" + i + "</li>";
    }
    /*onclick='changepage(" + i + ")'*/
    $("#pageGro ul").html(ul_html);
    $("#pageGro ul li").eq(eq).addClass("on");
    if (flag) {
        flag = false;
    } else {
        method(eq + 1);
    }
}

//上一页
function pageUp(pageNum, pageCount) {
    switch (pageNum) {
        case 1:
            break;
        case 2:
            page_icon(1, 5, 0);
            break;
        case pageCount - 1:
            page_icon(pageCount - 4, pageCount, 2);
            break;
        case pageCount:
            page_icon(pageCount - 4, pageCount, 3);
            break;
        default:
            page_icon(pageNum - 2, pageNum + 2, 1);
            break;
    }
}

//下一页
function pageDown(pageNum, pageCount) {
    switch (pageNum) {
        case 1:
            page_icon(1, 5, 1);
            break;
        case 2:
            page_icon(1, 5, 2);
            break;
        case pageCount - 1:
            page_icon(pageCount - 4, pageCount, 4);
            break;
        case pageCount:
            break;
        default:
            page_icon(pageNum - 2, pageNum + 2, 3);
            break;
    }
}