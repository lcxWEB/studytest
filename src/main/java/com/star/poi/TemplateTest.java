// package com.star.poi;
//
// import com.deepoove.poi.XWPFTemplate;
// import com.deepoove.poi.data.MiniTableRenderData;
// import com.deepoove.poi.data.RowRenderData;
// import com.deepoove.poi.data.TextRenderData;
// import com.deepoove.poi.data.style.Style;
// import com.deepoove.poi.data.style.TableStyle;
// import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
//
// import java.io.FileOutputStream;
// import java.time.LocalDateTime;
// import java.util.Arrays;
// import java.util.HashMap;
//
// public class TemplateTest {
//
//     public static void main(String[] args) throws Exception {
//
//         FileData fileData = new FileData();
//
//         Style headTextStyle = new Style();
//         TableStyle headStyle = new TableStyle();
//         TableStyle rowStyle = new TableStyle();
//         headTextStyle.setFontFamily("Hei");
//         headTextStyle.setFontSize(9);
//         headTextStyle.setColor("7F7F7F");
//
//         headStyle.setBackgroundColor("F2F2F2");
//         headStyle.setAlign(STJc.CENTER);
//
//         rowStyle.setAlign(STJc.CENTER);
//
//         RowRenderData header = RowRenderData.build(new TextRenderData("顺序号", headTextStyle), new TextRenderData("文号", headTextStyle),
//                 new TextRenderData("责任者", headTextStyle), new TextRenderData("题名", headTextStyle),
//                 new TextRenderData("日期", headTextStyle), new TextRenderData("页号", headTextStyle),
//                 new TextRenderData("备注", headTextStyle));
//         header.setStyle(headStyle);
//
//         DetailData detailData = new DetailData();
//         RowRenderData row = RowRenderData.build("1", "SN18090", "李四", "档案标题档案标题档案标题档案标题档案标题档案标题档案标题档案标题档案标题", LocalDateTime.now().toString(), "8", "备注======");
//         row.setStyle(rowStyle);
//         MiniTableRenderData miniTableRenderData = new MiniTableRenderData(header, Arrays.asList(row, row, row, row, row, row, row, row, row, row, row), MiniTableRenderData.WIDTH_A4_MEDIUM_FULL);
//
// //        List<RowRenderData> data = Arrays.asList(row, row, row, row, row, row, row, row, row, row, row);
// //        detailData.setFiles(data);
// //        fileData.setDetailData(detailData);
// //        fileData.setTitle("卷内文件目录");
// //        fileData.setDh("DQ112018综合");
// //
// //        Configure config = Configure.newBuilder().customPolicy("var", new DetailTablePolicy()).build();
//
//         XWPFTemplate template = XWPFTemplate.compile("src/main/resources/title.docx").render(
//                 new HashMap<String, Object>() {{
//                     put("title", "卷内文件目录");
//                     put("dh", "DQ112018综合");
//                     put("var", miniTableRenderData);
//                     put("pageNo", "1");
//                     put("totalPages", "2");
//                 }}
// //                fileData
//         );
//
//
//         FileOutputStream out = new FileOutputStream("out_template.docx");
//         template.write(out);
//         out.flush();
//         out.close();
//         template.close();
//     }
// }
