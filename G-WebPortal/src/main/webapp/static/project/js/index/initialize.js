
/**
 *  table初始化-Start
* */
$('#table').bootstrapTable({
    url: "getDataList2.html",
    columns: [
        {checkbox: true, align: 'center', valign: 'middle'},
        {field: 'code',     title: '编号',      align: 'center', valign: 'middle', width:12},
        {field: 'name',     title: '名称',      align: 'center', valign: 'middle', width:160},
        {field: 'calcMode', title: '计算方式',  align: 'center', valign: 'middle',

            formatter: function (value, row, index) { // 单元格格式化函数
                var text = '-';
                if (value == 1) {
                    text = "方式一";
                } else if (value == 2) {
                    text = "方式二";
                } else if (value == 3) {
                    text = "方式三";
                } else if (value == 4) {
                    text = "方式四";
                } else if (value == 5) {
                    text = "方式五";
                }
                return text;
            }
        },
        {title: "操作", align: 'center', valign: 'middle',

            formatter: function (value, row, index) {
                return '<button class="btn btn-primary btn-sm" onclick="del(\'' + row.stdId + '\')">删除</button>';
            }
        }
    ]
});

/**
 * @@param row  当前行数据对象
 * @@param index 当前行索引
 **/
function rowStyle(row, index) {
    /*        var classes = ['active', 'success', 'info', 'warning', 'danger'];
            if (row.code.indexOf('2') != -1) {
                return {
                    classes:['success']
                }
            }*/
    return {};

    /*        var style = {};
            style = {css:{'color':'#ed5565'}};
            return style;*/
    /*
            var style='info';
            return { classes: style }
    */
}
/**
 *  table初始化-End
 * */

