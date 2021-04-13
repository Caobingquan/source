package com.example.demo.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.CommonResponse;
import com.example.demo.pojo.Demo;
import com.example.demo.pojo.User;
import com.example.demo.pojo.aa;
import com.example.demo.utils.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.nio.channels.Channel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author {曹炳全}
 * @Description
 * @date 2020/9/2 14:50
 */
@Slf4j
public class TestDemo {

    @Test
    void b() {
        List<String> channels = new ArrayList<>();
        channels.add("channel1");
        channels.add("channel2");
        channels.add("channel3");
        List<String> cities = new ArrayList<>();
        cities.add("city1");
        cities.add("city2");
        cities.add("city3");


        List<String> channel1City1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel1City1.add("" + i);
        }
        List<String> channel1City2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel1City2.add("" + i + 2);
        }
        List<String> channel1City3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel1City3.add("" + i + 3);
        }
        List<String> channel2City1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel2City1.add("" + i * 2);
        }
        List<String> channel2City2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel2City2.add("" + i * 3);
        }
        List<String> channel2City3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel2City3.add("" + i + 1);
        }
        List<String> channel3City1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel3City1.add("" + i * 4);
        }
        List<String> channel3City2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel3City2.add("" + (i - 1));
        }
        List<String> channel3City3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            channel3City3.add("" + i + 23);
        }



        List<List<String>> channel1 = new ArrayList<>();
        channel1.add(channel1City1);
        channel1.add(channel1City2);
        channel1.add(channel1City3);
        List<List<String>> channel2 = new ArrayList<>();
        channel2.add(channel2City1);
        channel2.add(channel2City2);
        channel2.add(channel2City3);
        List<List<String>> channel3 = new ArrayList<>();
        channel3.add(channel3City1);
        channel3.add(channel3City2);
        channel3.add(channel3City3);
        //Map存按channel分的库存无货列表
        Map<String, List<List<String>>> map = new HashMap<>();
        map.put(channels.get(0), channel1);
        map.put(channels.get(1), channel2);
        map.put(channels.get(2), channel3);

        //存所有的无货列表
        List<List<String>> all = new ArrayList<>();
        all.add(channel1City1);
        all.add(channel1City2);
        all.add(channel1City3);
        all.add(channel2City1);
        all.add(channel2City2);
        all.add(channel2City3);
        all.add(channel3City1);
        all.add(channel3City2);
        all.add(channel3City3);
        //所有sku未去重
        List<String> allSkuCode = new ArrayList<>();
        //加入所有无货sku
        all.stream().forEach(a -> allSkuCode.addAll(a));
        //去重获得不重复的无货sku
        List<String> collect = allSkuCode.stream().distinct().collect(Collectors.toList());
//        System.out.println(allSkuCode.size());
//        System.out.println(collect.size());
//        System.out.println(allSkuCode.toString());
//        System.out.println(collect.toString());

        List<Demo> demos = new ArrayList<>();
        //遍历channel
        channels.forEach(
                channel -> collect.forEach(//遍历无货sku
                        skuCode -> {
                            //库存实体类
                            Demo demo = new Demo();
                            demo.setChannel(channel);
                            demo.setSku(skuCode);
                            List<Integer> a = new ArrayList<>();
                            //遍历一个channel下的地区库存。包含无货sku记录下地区id
                            for (int i = 0; i < map.get(channel).size(); i++) {
                                if (map.get(channel).get(i).contains(skuCode)) {
                                    a.add(i);
                                }
                            }
                            demo.setHaveNoSku(a);
                            demos.add(demo);
                        }));
        List<Demo> collect1 = demos.stream().filter(demo -> demo.getHaveNoSku().size() > 0).collect(Collectors.toList());
        System.out.println(demos.size());
        System.out.println(collect1.size());
        System.out.println(demos.toString());
        System.out.println(collect1.toString());
        System.out.println("over");
    }

    public class Demo {
        private String channel;
        private String sku;
        private List<Integer> haveNoSku;

        @Override
        public String toString() {
            return "Demo{" +
                    "channel='" + channel + '\'' +
                    ", sku='" + sku + '\'' +
                    ", haveNoSku=" + haveNoSku +
                    '}';
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public List<Integer> getHaveNoSku() {
            return haveNoSku;
        }

        public void setHaveNoSku(List<Integer> haveNoSku) {
            this.haveNoSku = haveNoSku;
        }
    }


    /**
     * stream只是给了地址，没有新建
     */
    @Test
    void c() {
        List<Demo> abc = new ArrayList<>();
        for(int i= 0;i<13;i++){
            Demo de = new Demo();
            de.setSku(""+i);
            abc.add(de);
        }
        abc.add(null);
        List<String> strings = abc.stream().map(df -> null != df ? df.getSku() : null).collect(Collectors.toList());

        List<Demo> collect2 = abc.stream().filter(a -> a.getSku().length() < 2).collect(Collectors.toList());
        collect2.get(0).setSku("66666");
        System.out.println(collect2.get(0).getSku());
        System.out.println(abc.get(0).getSku());
        List<String> aa= new ArrayList<>();
        aa.add("aaaa");
        aa.add("bbbb");
        aa.add("cccc");
        List<String> l = aa.stream().map(s -> StringUtils.replace("dfdf:{SKU}", "{SKU}", s))
                .collect(Collectors.toList());
        System.out.println(aa.toString());
        System.out.println(l.toString());
    }
    /**
     * list为null,foreach方法会空指针异常，
     */
    @Test
    void d() {
        List<String> abc = new ArrayList<>();
        for(int i= 0;i<13;i++){
            abc.add(""+i);
        }
        List<String> a = new ArrayList<>();
        for (String demo: a) {

        }
//        List<String> b = new ArrayList<>();
//        b = null;
//        for (String demo: b) {
//
//        }

        abc.add(0,"aa");

    }
    /**
     * list.subList(startIndex,size);
     * list.add(index,value),index不能大于size
     */
    @Test
    void e() {
        List<String> abc = new ArrayList<>();
        for(int i= 0;i<13;i++){
            abc.add(""+i);
        }
        List<String> b = new ArrayList<>();
        b.add("aa");
        abc.add(0,"aa");
        abc.add(20,"20");
        int startIndex = 0;
        int size = 4;
        abc.subList(startIndex,size);
    }
    /**
     * 时间类型
     */
    @Test
    void f() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date  data = new Date();
        String end = formatter.format(data);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MINUTE, -1);
        String start = formatter.format(calendar.getTime());
        log.info("start:"+start+",end:"+end);
    }

    /**
     * stream处理的list不为null
     *
     */
    @Test
    void g() {
        List<String> abc = new ArrayList<>();
        for(int i= 0;i<13;i++){
            abc.add(""+i);
        }
        List<String> collect = abc.stream().filter(a -> a.length() > 6).collect(Collectors.toList());
        System.out.println(collect.toString());

        System.out.println(abc.toString());

    }

    /**
     * stream处理的list不为null
     *
     */
    @Test
    void h() {
        List<String> abc = new ArrayList<>();
        abc.add("地方");
        abc.add("公共");
        abc.add(" 帝国时代");
        abc.add("打是");
        abc.add("德国人和");
        abc.add("说得对");
        abc.add("然后他单位分管");
        abc.add("十大歌手");
        System.out.println(abc.toString());
        System.out.println(abc.toArray());
        for(int i= 0;i<13;i++){
            abc.add(""+i);
        }
        List<String> collect = abc.stream().filter(a -> a.length() > 6).collect(Collectors.toList());
        System.out.println(collect.toString());

        String s = JSON.toJSONString(abc.stream().filter(a -> a.length()>100).collect(Collectors.toList()));
        System.out.println("");
        List<String> c = new ArrayList<>();
        c.forEach(a-> System.out.println("a"));
        List<String> aa = null;
        for (String a:
             aa) {
            System.out.println(a);
        }
    }

    /**
     * stream处理的list不为null
     *
     */
    @Test
    void i() {
        List<String> strings=new ArrayList<>();
        strings.add("小门");
        strings.add("小对的");
        strings.add("地方");
        strings.add("达观");
        String join = StringUtils.join(strings, ",");
        System.out.println(join);
        String[] aa = strings.toArray(new String[strings.size()]);
        System.out.println(aa);
        System.out.println(Arrays.toString(aa));
        StringUtils.join(strings,",");
        System.out.println(aa.toString());

    }
    /**
     * stream处理的list不为null
     *
     */
    @Test
    void j() {
        User user = new User();
        user.setName("sss");
        user.setPass("dddd");
        Map<String,Object> map = new HashMap<>();
        map.put("name","[111,222]");
        map.put("school","[\"aaa\",\"bbb\"]");
        map.put("dd","[]");
        map.put("ff"," ");

        Map<String,Object> map1 = JSONObject.parseObject(JSON.toJSONString(user));
        for(String key:map.keySet()){
            map1.put(key,map.get(key));
        }

        String join = StringUtils.join(JSONArray.parseArray((String) map1.get("dd"), Object.class), ",");
        String aa = StringUtils.join(JSONArray.parseArray((String) map1.get("ff"), Object.class), ",");
        System.out.println("ddd");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("aa","aa");
        map2.put("bb","aa");
        map2.put("cc","aa");
        map2.put("gg","aa");
        map2.put("rr","aa");
        List<String> mediaArray = new ArrayList(Arrays.asList("aa,bb,cc,dd,ee,ff,gg".split(",")));
        Set<String> uploadField = map2.keySet();
        mediaArray.retainAll(uploadField);
        for (String key : mediaArray) {
            map.put(key, StringUtils.join(JSONArray.parseArray(JSON.toJSONString(map.get(key)), Object.class), ","));
        }

        System.out.println("ddd");

    }

    @Test
    void k(){
        List<String> abc = new ArrayList<>();
        abc.add("aa");
        abc.add("bb");
        abc.add(" cc");
        abc.add("dd");
        List<String> dd = new ArrayList<>();
        dd.add("ee");
        dd.add("ff");
        dd.add("gg");
        dd.add("hh");
        List<List<String>> listList = new ArrayList<>();
        listList.add(abc);
        listList.add(dd);
        List<String> collect = listList.stream().flatMap(list -> list.stream().map(String::toUpperCase))
                .collect(Collectors.toList());
        System.out.println("aa");
    }
    @Test
    void L(){
        String a = "aaaa";
        String c = "query=(default:'哈哈哈' OR aemtags:'哈哈哈') AND (allowidentities:\"PC\" OR aboreadonly:\"0\")  ANDNOT (tags:\"分类页\" OR aemtags:\"分类页\") ANDNOT (url:\"/content/china/accl/aaworkshop/\")&&config=start:0,format:fulljson,rerank_size:2000&&kvpairs=filter_punc:0";
        Object object= a;
        List<String> b = new ArrayList<>();
        b.add("adgdfd");
        b.add("bb");
        Object o = b;
        String str = JSON.toJSONString(o);
        User user = new User();
        user.setDemos(new ArrayList<>());
        List<com.example.demo.pojo.Demo> add = user.getDemos();


        JSONArray.parseArray("");



    }
    @Test
    void Ldd(){
        int a=3;
        String now = DateUtil.now();
        //拉取商品的时间（有偏移）
        Date lastTime = DateUtil.offsetMinute(DateUtil.parse(now), -a);
        String s = DateUtil.formatDateTime(lastTime);
        System.out.println(s);

    }
    @Test
    void csv(){
        List<String> aa = new ArrayList<>();
        aa.add("aa");
        aa.add("bb");
        aa.add("cc");
        aa.add("dd");
        List<String> bb = new ArrayList<>();
        bb.add("aa");
        bb.add("bb");
        bb.add("cc");
        bb.add("hh");
        List<String> lose = new ArrayList<>(aa);
        List<String> add = new ArrayList<>(bb);
        lose.removeAll(bb);
        add.removeAll(aa);
        System.out.println(StringUtils.join(add, ","));
        System.out.println(StringUtils.join(lose, ","));

    }

}
