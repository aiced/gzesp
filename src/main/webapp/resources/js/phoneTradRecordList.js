/**
 * Created by xinjunwang on 15-6-18.
 */

$(function(){
    initBind();
});
function initBind(){
    $("ul").delegate("li", "click", function(){
        alert( $(this).index());
    });
}