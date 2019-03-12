import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;

/**
 * @author chenchen
 * @date 2019/1/17 20:26
 * @Content:
 */
public class Ngram {
    public static int[] range(int start,int end,int step){
        int sz = (int) Math.ceil((end-start)/step);

         int[] result=new int[sz];
         for(int i=0;i<sz;i++)
            result[i]=start+(i*step);
         return result;
    }
    public static void main(String[] args) throws Exception{


    String[] title = {"Study in China","Study in Japan","Study in Korea"};
    double[][] values ={
            {5.416265526358988e-10, 4.746275622524721e-10, 4.958808849653273e-10, 4.2504075854170916e-10, 5.29406139958079e-10, 5.225150015045596e-10, 7.081130106881669e-10, 6.457105782604294e-10, 7.688789426569492e-10, 8.040085799513161e-10, 1.1976277172357337e-09, 1.751433504179215e-09, 2.0890621296335408e-09, 2.2106159918473215e-09, 2.1641312868731735e-09, 2.2401449425605134e-09, 2.4053541856718296e-09, 2.239536016952164e-09, 1.8957399459752976e-09, 1.8525894152077171e-09, 1.652919293501246e-09, 1.6289345269474405e-09, 1.6622217570626064e-09, 1.7935857878269091e-09, 1.8529809591478446e-09, 1.69722720005134e-09, 1.5984681673535712e-09, 1.6579841467999147e-09, 1.801193675691574e-09, 1.7946491404075005e-09, 1.5122944563294993e-09},
            {3.846464036172392e-09, 4.11032923253174e-09, 4.127779747638745e-09, 4.10315140594467e-09, 4.127524544372818e-09, 4.065504298291143e-09, 4.054731233311364e-09, 3.428174585476792e-09, 3.606327569904977e-09, 3.3070568664480706e-09, 3.487807074899406e-09, 3.5228403844860576e-09, 4.17804473557786e-09, 5.116214626558044e-09, 5.069217870864609e-09, 4.5451534282290956e-09, 4.592272118131291e-09, 4.089455123741053e-09, 3.7351399750917835e-09, 3.0750405238017767e-09, 2.1283533824245637e-09, 2.18249531145988e-09, 2.1153019494743066e-09, 2.0664563235176357e-09, 2.031438255707079e-09, 2.101383162716226e-09, 2.351567496283735e-09, 2.373078828681636e-09, 2.302667889697574e-09, 2.3083902123133272e-09, 2.3584755537431334e-09},
            {3.883863682052624e-10, 8.066249362892464e-10, 7.390927245221057e-10, 7.949521774979524e-10, 9.121484460607374e-10, 8.914750307001792e-10, 9.567531905618765e-10, 1.0643112185222086e-09, 9.50022592340259e-10, 1.0138259200407974e-09, 9.352489814342034e-10, 7.902193502725855e-10, 8.687915387106671e-10, 8.081282508255936e-10, 7.387425631539507e-10, 5.314771341278859e-10, 5.216886228565087e-10, 5.451285474609793e-10, 5.503881021575095e-10, 4.3614321479764785e-10, 4.00550626397259e-10, 4.5702055830241864e-10, 4.872261443506736e-10, 3.9529296899257615e-10, 3.979223260421248e-10, 4.203676613150671e-10, 4.878516995138987e-10, 5.391786660004425e-10, 4.826084948339471e-10, 4.911022088993633e-10, 5.798769728282416e-10}
    };
        int[] years = range(1978, 2009, 1);
       // System.out.println(years.toString());
    // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        //POIFSFileSystem fs =new POIFSFileSystem(new FileInputStream("workbook.xls"));
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("中日韩三国高等教育吸引力比较2");



    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
    HSSFRow row = sheet.createRow(0);

    // 第四步，创建单元格，并设置值表头 设置表头居中
    HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

    //声明列对象
    HSSFCell cell = null;

    //创建标题
//
//        cell = row.createCell(0);
////设置单元格内容
//        cell.setCellValue("1900-2008");
////合并单元格CellRangeAddress  参数依次表示  起始行，截止行，起始列，截止列
//        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        cell = row.createCell(0);
        cell.setCellValue("years");
        cell.setCellStyle(style);
        for(int i=0;i<years.length;i++){
            cell = row.createCell(i+1);
            cell.setCellValue(years[i]);
            cell.setCellStyle(style);

        }
    //创建内容

        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1); //行
            for(int j=0;j<values[i].length;j++){
            //将内容按顺序赋给对应的列对象
              cell =   row.createCell(0);
              cell.setCellStyle(style);
                cell.setCellValue(title[i]);
            row.createCell(j+1).setCellValue(values[i][j]);
        }
    }
        FileOutputStream fileOut = new FileOutputStream("中日韩三国高等教育吸引力比较2.xls");

        wb.write(fileOut);

        fileOut.close();

    }
}
