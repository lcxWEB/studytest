// package com.star.poi;
//
// import com.deepoove.poi.NiceXWPFDocument;
// import com.deepoove.poi.XWPFTemplate;
// import com.deepoove.poi.data.MiniTableRenderData;
// import com.deepoove.poi.policy.AbstractRenderPolicy;
// import com.deepoove.poi.template.run.RunTemplate;
// import com.deepoove.poi.util.TableTools;
// import org.apache.poi.xwpf.usermodel.XWPFRun;
// import org.apache.poi.xwpf.usermodel.XWPFTable;
//
// public class CustomTableRenderPolicy extends AbstractRenderPolicy {
//
//     @Override
//     protected boolean validate(Object data) {
//         return null != data;
//     }
//
//     @Override
//     public void doRender(RunTemplate runTemplate, Object data, XWPFTemplate template)
//             throws Exception {
//
//         NiceXWPFDocument doc = template.getXWPFDocument();
//         XWPFRun run = runTemplate.getRun();
//         // 定义行列
//         int row = 10, col = 8;
//         // 插入表格
//         XWPFTable table = doc.insertNewTable(run, row, col);
//
//         // 定义表格宽度、边框和样式
//         TableTools.widthTable(table, MiniTableRenderData.WIDTH_A4_FULL, col);
//         TableTools.borderTable(table, 4);
//
//         // TODO 调用XWPFTable API操作表格：data对象可以包含任意你想要的数据，包括图片文本等
//         // TODO 调用MiniTableRenderPolicy.renderRow方法快速方便的渲染一行数据
//         // TODO 调用TableTools类方法操作表格，比如合并单元格
//         // ......
//         TableTools.mergeCellsHorizonal(table, 0, 0, 7);
//         TableTools.mergeCellsVertically(table, 0, 1, 9);
//
//         // 清空原先模板
//         clearPlaceholder(run);
//     }
// }
