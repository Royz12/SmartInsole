package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.*;
import com.graduationdesign.springbootsmartinsole.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportAnalysisService {
    @Autowired
    private SportAnalysisMapper sportAnalysisMapper;
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    @Autowired
    private BindExpertMapper bindExpertMapper;
    @Autowired
    private BindInsoleMapper bindInsoleMapper;
    @Autowired
    private LeftInsoleMapper leftInsoleMapper;
    @Autowired
    private RightInsoleMapper rightInsoleMapper;
    @Autowired
    private ExpertInfoMapper expertInfoMapper;
//    public SportAnalysis getleftavg(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getleftavg(sportmanInfo);
//    }
//
//    public SportAnalysis getrightavg(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getrightavg(sportmanInfo);
//    }
//
//    public SportAnalysis getrightdir(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getrightdir(sportmanInfo);
//    }
//
//    public SportAnalysis getrightleft(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getleftdir(sportmanInfo);
//    }

    public void addRecord(ExpertInfo expertInfo) {
        List<BindExpert> bindExpertList;
        bindExpertList= bindExpertMapper.searchListByexpert_id(expertInfo);
        for (int i=0;i<bindExpertList.size();i++){
            BindExpert bindExpert=bindExpertList.get(i);

            SportmanInfo dto=new SportmanInfo();
            dto.setSportman_id(bindExpert.getSportman_id());
            SportmanInfo sportmanInfo=sportmanInfoMapper.searchById(dto);

            SportAnalysis sportAnalysis =new SportAnalysis();
            SportAnalysis sportAnalysis_left;
            SportAnalysis sportAnalysis_right;
            SportAnalysis sportAnalysis_null;

            sportAnalysis.setSportman_id(sportmanInfo.getSportman_id());
            sportAnalysis.setSportman_name(sportmanInfo.getSportman_name());
            sportAnalysis.setLeft_average(sportAnalysisMapper.getleftavg(sportmanInfo));
            sportAnalysis.setRight_average(sportAnalysisMapper.getrightavg(sportmanInfo));
            sportAnalysis.setLeft_result(sportAnalysisMapper.getleftdir(sportmanInfo));
            sportAnalysis.setRight_result(sportAnalysisMapper.getrightdir(sportmanInfo));

            //获取左右脚四个鞋垫区域压力(总共八个)
            sportAnalysis_left=sportAnalysisMapper.getleft_little_avg(sportmanInfo);
            sportAnalysis_right=sportAnalysisMapper.getright_little_avg(sportmanInfo);

            sportAnalysis.setLeft_result_1(sportAnalysis_left.getLeft_result_1());
            sportAnalysis.setLeft_result_2(sportAnalysis_left.getLeft_result_2());
            sportAnalysis.setLeft_result_3(sportAnalysis_left.getLeft_result_3());
            sportAnalysis.setLeft_result_4(sportAnalysis_left.getLeft_result_4());

            sportAnalysis.setRight_result_1(sportAnalysis_right.getRight_result_1());
            sportAnalysis.setRight_result_2(sportAnalysis_right.getRight_result_2());
            sportAnalysis.setRight_result_3(sportAnalysis_right.getRight_result_3());
            sportAnalysis.setRight_result_4(sportAnalysis_right.getRight_result_4());

            sportAnalysis_null=sportAnalysisMapper.getrecord(sportmanInfo);

            sportAnalysisMapper.addRecord(sportAnalysis);
        }

    }

    public List<Data> echarts_data(ExpertInfo expertInfo) {
        List<Data> dataList=new ArrayList<>();
        List<BindExpert> record_bindexpert_idlist=sportAnalysisMapper.search_record_idList(expertInfo);
        for(int i=0;i<record_bindexpert_idlist.size();i++){
            double[] valueList =new double[2];
            Sole_data sole_data=new Sole_data();
            Sole_data sole_data1=new Sole_data();
            double[] value=new double[4];
            double[] value1=new double[4];
            List<Sole_data> valueList1=new ArrayList<>();
            Data result=new Data();
            BindExpert bindExpert;
            SportmanInfo sportmanInfo=new SportmanInfo();
            SportAnalysis sportAnalysis;

            bindExpert=record_bindexpert_idlist.get(i);
            sportmanInfo.setSportman_id(bindExpert.getSportman_id());
            SportmanInfo sportmanInfo1=sportmanInfoMapper.searchById(sportmanInfo);

            sportAnalysis=sportAnalysisMapper.getrecord(sportmanInfo);

            valueList[0]=sportAnalysis.getLeft_average();
            valueList[1]=sportAnalysis.getRight_average();

            sole_data.setName("左脚");
            value[0]=sportAnalysis.getLeft_result_1();
            value[1]=sportAnalysis.getLeft_result_2();
            value[2]=sportAnalysis.getLeft_result_3();
            value[3]=sportAnalysis.getLeft_result_4();
            sole_data.setValue(value);

            sole_data1.setName("右脚");
            value1[0]=sportAnalysis.getRight_result_1();
            value1[1]=sportAnalysis.getRight_result_2();
            value1[2]=sportAnalysis.getRight_result_3();
            value1[3]=sportAnalysis.getRight_result_4();
            sole_data1.setValue(value1);

            valueList1.add(sole_data);
            valueList1.add(sole_data1);

            result.setId(bindExpert.getRecord_id());
            result.setName(sportmanInfo1.getSportman_name());
            result.setSportman_id(bindExpert.getSportman_id());
            result.setValueList(valueList);
            result.setValueList1(valueList1);
            result.setHeight(sportmanInfo1.getHeight());
            result.setWeight(sportmanInfo1.getWeight());

            //热力图数据
            BindInsole bindInsole=bindInsoleMapper.selectById(sportmanInfo);
            LeftInsole leftInsole=leftInsoleMapper.selectById(bindInsole);
            RightInsole rightInsole=rightInsoleMapper.selectById(bindInsole);
            System.out.println(rightInsole);
            int a=0;

            String[] result1=new String[5544];
            int[][] data=new int[72][77];
            for (int x=0;x<72;x++){
                for (int y=0;y<77;y++){
                    data[x][y]=0;
                }
            }

            //左11
            a= Integer.parseInt(leftInsole.getL13());
            for (int x=8;x<=14;x++){
                for (int y=2;y<=12;y++){
                    data[x][y]=a;
                }
            }

            //左12
            a= Integer.parseInt(leftInsole.getL12());
            for (int x=16;x<=22;x++){
                for (int y=2;y<=12;y++){
                    data[x][y]=a;
                }
            }

            //左21
            a= Integer.parseInt(leftInsole.getL22());
            for (int x=8;x<=14;x++){
                for (int y=14;y<=24;y++){
                    data[x][y]=a;
                }
            }

            //左22
            a= Integer.parseInt(leftInsole.getL21());
            for (int x=16;x<=22;x++){
                for (int y=14;y<=24;y++){
                    data[x][y]=a;
                }
            }

            //左31
            a= Integer.parseInt(leftInsole.getL34());
            for (int x=5;x<=10;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }

            //左32
            a= Integer.parseInt(leftInsole.getL33());
            for (int x=12;x<=17;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }

            //左33
            a= Integer.parseInt(leftInsole.getL32());
            for (int x=19;x<=24;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }

            //左41
            a= Integer.parseInt(leftInsole.getL44());
            for (int x=2;x<=17;x++){
                for (int y=38;y<=48;y++){
                    data[x][y]=a;
                }
            }

            //左51
            a= Integer.parseInt(leftInsole.getL54());
            for (int x=5;x<=10;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //左52
            a= Integer.parseInt(leftInsole.getL53());
            for (int x=12;x<=17;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //左53
            a= Integer.parseInt(leftInsole.getL52());
            for (int x=19;x<=24;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //左54
            a= Integer.parseInt(leftInsole.getL52());
            for (int x=26;x<=31;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //左61
            a= Integer.parseInt(leftInsole.getL64());
            for (int x=8;x<=13;x++){
                for (int y=62;y<=72;y++){
                    data[x][y]=a;
                }
            }

            //左62
            a= Integer.parseInt(leftInsole.getL63());
            for (int x=15;x<=20;x++){
                for (int y=62;y<=75;y++){
                    data[x][y]=a;
                }
            }

            //左63
            a= Integer.parseInt(leftInsole.getL62());
            for (int x=22;x<=27;x++){
                for (int y=62;y<=75;y++){
                    data[x][y]=a;
                }
            }

            //左64
            a= Integer.parseInt(leftInsole.getL61());
            for (int x=29;x<=34;x++){
                for (int y=62;y<=72;y++){
                    data[x][y]=a;
                }
            }

            //右61
            a=Integer.parseInt(rightInsole.getR61());
            for (int x=40;x<=45;x++){
                for (int y=62;y<=72;y++){
                    data[x][y]=a;
                }
            }

            //右62
            a=Integer.parseInt(rightInsole.getR62());
            for (int x=47;x<=52;x++){
                for (int y=62;y<=75;y++){
                    data[x][y]=a;
                }
            }

            //右63
            a=Integer.parseInt(rightInsole.getR63());
            for (int x=54;x<=57;x++){
                for (int y=62;y<=75;y++){
                    data[x][y]=a;
                }
            }

            //右64
            a=Integer.parseInt(rightInsole.getR64());
            for (int x=59;x<=64;x++){
                for (int y=62;y<=72;y++){
                    data[x][y]=a;
                }
            }

            //右54
            a=Integer.parseInt(rightInsole.getR54());
            for (int x=62;x<=67;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //右53
            a=Integer.parseInt(rightInsole.getR53());
            for (int x=55;x<=60;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //右52
            a=Integer.parseInt(rightInsole.getR52());
            for (int x=48;x<=53;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //右51
            a=Integer.parseInt(rightInsole.getR51());
            for (int x=41;x<=46;x++){
                for (int y=50;y<=60;y++){
                    data[x][y]=a;
                }
            }

            //右41
            a= Integer.parseInt(rightInsole.getR44());
            for (int x=55;x<=70;x++){
                for (int y=38;y<=48;y++){
                    data[x][y]=a;
                }
            }

            //右34
            a= Integer.parseInt(rightInsole.getR34());
            for (int x=62;x<=67;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }


            //右33
            a=Integer.parseInt(rightInsole.getR33());
            for (int x=55;x<=60;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }

            //右32
            a=Integer.parseInt(rightInsole.getR32());
            for (int x=48;x<=53;x++){
                for (int y=26;y<=36;y++){
                    data[x][y]=a;
                }
            }

            //右21
            a=Integer.parseInt(rightInsole.getR21());
            for (int x=52;x<=57;x++){
                for (int y=14;y<=24;y++){
                    data[x][y]=a;
                }
            }

            //右22
            a=Integer.parseInt(rightInsole.getR22());
            for (int x=59;x<=64;x++){
                for (int y=14;y<=24;y++){
                    data[x][y]=a;
                }
            }

            //右11
            a=Integer.parseInt(rightInsole.getR12());
            for (int x=52;x<=57;x++){
                for (int y=2;y<=12;y++){
                    data[x][y]=a;
                }
            }

            //右12
            a=Integer.parseInt(rightInsole.getR13());
            for (int x=59;x<=64;x++){
                for (int y=2;y<=12;y++){
                    data[x][y]=a;
                }
            }




            //将数据输入到result数组
            a=0;
            for (int x=0;x<72;x++){
                for (int y=0;y<77;y++){
                    result1[a] = "[" + x + "," + y + "," + data[x][y] + "]";
                    a++;
                }
            }

            result.setResult(result1);

            dataList.add(result);
        }
        return dataList;
    }

    public SportAnalysis searchRecord(SportmanInfo sportmanInfo) {
        SportAnalysis sportAnalysis;
        sportAnalysis=sportAnalysisMapper.getrecord(sportmanInfo);
        return sportAnalysis;
    }

    public List<Data> sportman_echarts_data(SportmanInfo sportmanInfo) {
        List<Data> dataList=new ArrayList<>();
        SportAnalysis sportAnalysis=new SportAnalysis();
        Data data=new Data();

        double[] valueList =new double[2];

        List<Sole_data> valueList1=new ArrayList<>();
        Sole_data sole_data=new Sole_data();
        Sole_data sole_data1=new Sole_data();
        double[] value=new double[4];
        double[] value1=new double[4];

        sportAnalysis=sportAnalysisMapper.getrecord(sportmanInfo);

        valueList[0]=sportAnalysis.getLeft_average();
        valueList[1]=sportAnalysis.getRight_average();

        sole_data.setName("左脚");
        value[0]=sportAnalysis.getLeft_result_1();
        value[1]=sportAnalysis.getLeft_result_2();
        value[2]=sportAnalysis.getLeft_result_3();
        value[3]=sportAnalysis.getLeft_result_4();
        sole_data.setValue(value);

        sole_data1.setName("右脚");
        value1[0]=sportAnalysis.getRight_result_1();
        value1[1]=sportAnalysis.getRight_result_2();
        value1[2]=sportAnalysis.getRight_result_3();
        value1[3]=sportAnalysis.getRight_result_4();
        sole_data1.setValue(value1);

        valueList1.add(sole_data);
        valueList1.add(sole_data1);

        data.setId(1);
        data.setName(sportmanInfo.getSportman_name());
        data.setSportman_id(sportmanInfo.getSportman_id());
        data.setValueList(valueList);
        data.setValueList1(valueList1);
        data.setWeight(sportmanInfo.getWeight());
        data.setHeight(sportmanInfo.getHeight());

        dataList.add(data);


        return dataList;
    }


    public String[] sole_data(SportmanInfo sportmanInfo) {

        BindInsole bindInsole=bindInsoleMapper.selectById(sportmanInfo);
        LeftInsole leftInsole=leftInsoleMapper.selectById(bindInsole);
        RightInsole rightInsole=rightInsoleMapper.selectById(bindInsole);
        System.out.println(rightInsole);
        int a=0;

        String[] result=new String[5544];
        int[][] data=new int[72][77];
        for (int x=0;x<72;x++){
            for (int y=0;y<77;y++){
                data[x][y]=0;
            }
        }

        //左11
        a= Integer.parseInt(leftInsole.getL13());
        for (int x=8;x<=14;x++){
            for (int y=2;y<=12;y++){
                data[x][y]=a;
            }
        }

        //左12
        a= Integer.parseInt(leftInsole.getL12());
        for (int x=16;x<=22;x++){
            for (int y=2;y<=12;y++){
                data[x][y]=a;
            }
        }

        //左21
        a= Integer.parseInt(leftInsole.getL22());
        for (int x=8;x<=14;x++){
            for (int y=14;y<=24;y++){
                data[x][y]=a;
            }
        }

        //左22
        a= Integer.parseInt(leftInsole.getL21());
        for (int x=16;x<=22;x++){
            for (int y=14;y<=24;y++){
                data[x][y]=a;
            }
        }

        //左31
        a= Integer.parseInt(leftInsole.getL34());
        for (int x=5;x<=10;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }

        //左32
        a= Integer.parseInt(leftInsole.getL33());
        for (int x=12;x<=17;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }

        //左33
        a= Integer.parseInt(leftInsole.getL32());
        for (int x=19;x<=24;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }

        //左41
        a= Integer.parseInt(leftInsole.getL44());
        for (int x=2;x<=17;x++){
            for (int y=38;y<=48;y++){
                data[x][y]=a;
            }
        }

        //左51
        a= Integer.parseInt(leftInsole.getL54());
        for (int x=5;x<=10;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //左52
        a= Integer.parseInt(leftInsole.getL53());
        for (int x=12;x<=17;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //左53
        a= Integer.parseInt(leftInsole.getL52());
        for (int x=19;x<=24;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //左54
        a= Integer.parseInt(leftInsole.getL52());
        for (int x=26;x<=31;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //左61
        a= Integer.parseInt(leftInsole.getL64());
        for (int x=8;x<=13;x++){
            for (int y=62;y<=72;y++){
                data[x][y]=a;
            }
        }

        //左62
        a= Integer.parseInt(leftInsole.getL63());
        for (int x=15;x<=20;x++){
            for (int y=62;y<=75;y++){
                data[x][y]=a;
            }
        }

        //左63
        a= Integer.parseInt(leftInsole.getL62());
        for (int x=22;x<=27;x++){
            for (int y=62;y<=75;y++){
                data[x][y]=a;
            }
        }

        //左64
        a= Integer.parseInt(leftInsole.getL61());
        for (int x=29;x<=34;x++){
            for (int y=62;y<=72;y++){
                data[x][y]=a;
            }
        }

        //右61
        a=Integer.parseInt(rightInsole.getR61());
        for (int x=40;x<=45;x++){
            for (int y=62;y<=72;y++){
                data[x][y]=a;
            }
        }

        //右62
        a=Integer.parseInt(rightInsole.getR62());
        for (int x=47;x<=52;x++){
            for (int y=62;y<=75;y++){
                data[x][y]=a;
            }
        }

        //右63
        a=Integer.parseInt(rightInsole.getR63());
        for (int x=54;x<=57;x++){
            for (int y=62;y<=75;y++){
                data[x][y]=a;
            }
        }

        //右64
        a=Integer.parseInt(rightInsole.getR64());
        for (int x=59;x<=64;x++){
            for (int y=62;y<=72;y++){
                data[x][y]=a;
            }
        }

        //右54
        a=Integer.parseInt(rightInsole.getR54());
        for (int x=62;x<=67;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //右53
        a=Integer.parseInt(rightInsole.getR53());
        for (int x=55;x<=60;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //右52
        a=Integer.parseInt(rightInsole.getR52());
        for (int x=48;x<=53;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //右51
        a=Integer.parseInt(rightInsole.getR51());
        for (int x=41;x<=46;x++){
            for (int y=50;y<=60;y++){
                data[x][y]=a;
            }
        }

        //右41
        a= Integer.parseInt(rightInsole.getR44());
        for (int x=55;x<=70;x++){
            for (int y=38;y<=48;y++){
                data[x][y]=a;
            }
        }

        //右34
        a= Integer.parseInt(rightInsole.getR34());
        for (int x=62;x<=67;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }


        //右33
        a=Integer.parseInt(rightInsole.getR33());
        for (int x=55;x<=60;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }

        //右32
        a=Integer.parseInt(rightInsole.getR32());
        for (int x=48;x<=53;x++){
            for (int y=26;y<=36;y++){
                data[x][y]=a;
            }
        }

        //右21
        a=Integer.parseInt(rightInsole.getR21());
        for (int x=52;x<=57;x++){
            for (int y=14;y<=24;y++){
                data[x][y]=a;
            }
        }

        //右22
        a=Integer.parseInt(rightInsole.getR22());
        for (int x=59;x<=64;x++){
            for (int y=14;y<=24;y++){
                data[x][y]=a;
            }
        }

        //右11
        a=Integer.parseInt(rightInsole.getR12());
        for (int x=52;x<=57;x++){
            for (int y=2;y<=12;y++){
                data[x][y]=a;
            }
        }

        //右12
        a=Integer.parseInt(rightInsole.getR13());
        for (int x=59;x<=64;x++){
            for (int y=2;y<=12;y++){
                data[x][y]=a;
            }
        }




        //将数据输入到result数组
        a=0;
        for (int x=0;x<72;x++){
            for (int y=0;y<77;y++){
                result[a] = "[" + x + "," + y + "," + data[x][y] + "]";
                a++;
            }
        }
        return result;
    }

    public void addRecordBySportman(SportmanInfo sportmanInfo) {
        
        SportAnalysis sportAnalysis =new SportAnalysis();
        SportAnalysis sportAnalysis_left;
        SportAnalysis sportAnalysis_right;

        sportAnalysis.setSportman_id(sportmanInfo.getSportman_id());
        sportAnalysis.setSportman_name(sportmanInfo.getSportman_name());
        sportAnalysis.setLeft_average(sportAnalysisMapper.getleftavg(sportmanInfo));
        sportAnalysis.setRight_average(sportAnalysisMapper.getrightavg(sportmanInfo));
        sportAnalysis.setLeft_result(sportAnalysisMapper.getleftdir(sportmanInfo));
        sportAnalysis.setRight_result(sportAnalysisMapper.getrightdir(sportmanInfo));

        //获取左右脚四个鞋垫区域压力(总共八个)
        sportAnalysis_left=sportAnalysisMapper.getleft_little_avg(sportmanInfo);
        sportAnalysis_right=sportAnalysisMapper.getright_little_avg(sportmanInfo);

        sportAnalysis.setLeft_result_1(sportAnalysis_left.getLeft_result_1());
        sportAnalysis.setLeft_result_2(sportAnalysis_left.getLeft_result_2());
        sportAnalysis.setLeft_result_3(sportAnalysis_left.getLeft_result_3());
        sportAnalysis.setLeft_result_4(sportAnalysis_left.getLeft_result_4());

        sportAnalysis.setRight_result_1(sportAnalysis_right.getRight_result_1());
        sportAnalysis.setRight_result_2(sportAnalysis_right.getRight_result_2());
        sportAnalysis.setRight_result_3(sportAnalysis_right.getRight_result_3());
        sportAnalysis.setRight_result_4(sportAnalysis_right.getRight_result_4());


        sportAnalysisMapper.addRecord(sportAnalysis);
    }
}
