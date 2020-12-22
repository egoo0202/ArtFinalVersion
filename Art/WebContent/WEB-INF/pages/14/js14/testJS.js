$(document).ready(function () {
            $(".ii").mouseover(function () {
                var no = $(this);
                $(".ii").each(function (index) {
                    $(this).addClass("hovers");
                    if (index == no.index()) {
                    $(".num").text(index+1);
                        return false;
                    }
                });
            })

            $(".ii").mouseleave(function(){
                    $(".ii").removeClass("hovers");
                
            })

            $(".ii").click(function(){
                var no = $(this);
                $(".ii").removeClass("clicked");
                $(".ii").each(function (index) {
                    $(this).addClass("clicked");
                    if (index == no.index()) {
                        return false;
                    }
                $(".divRatiing").html("感謝你給予本商品 "+ (($(".clicked").length)+1) +" 顆星的評價!");
            })
        })

    })