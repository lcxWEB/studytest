package com.star.poi;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.policy.DynamicTableRenderPolicy;
import com.deepoove.poi.policy.MiniTableRenderPolicy;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.util.List;

public class DetailTablePolicy extends DynamicTableRenderPolicy {

    int filesStartRow = 2;

    @Override
    public void render(XWPFTable table, Object data) {
        if (null == data) return;
        DetailData detailData = (DetailData) data;

        List<RowRenderData> files = detailData.getFiles();
        if (null != files) {
            table.removeRow(filesStartRow);
            for (int i = 0; i < files.size(); i++) {
                XWPFTableRow insertNewTableRow = table.insertNewTableRow(filesStartRow);
                for (int j = 0; j < 7; j++) insertNewTableRow.createCell();
                MiniTableRenderPolicy.renderRow(table, filesStartRow, files.get(i));
            }
        }
    }
}
