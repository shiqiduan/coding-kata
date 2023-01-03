package com.duan.leetcode.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiqiduan
 */
public class CustomObj {
    private List<CustomObj> values;

    public CustomObj() {
        this.values = new ArrayList<>();
    }

    public void add(CustomObj item) {
        this.values.add(item);
    }

    protected static CustomObj parse(String str) {
        if(str == null || str.length() == 0) return null;
        if(!str.startsWith("{") || !str.endsWith("}")) {
            throw new IllegalArgumentException("Invalid str");
        }
        String content = str.substring(1, str.length() - 1);
        if(content.length() == 0) {
            return null;
        }

        CustomObj obj = new CustomObj();
        content = content + ",";

        StringBuilder field = new StringBuilder();
        int start = 0;
        for(Character c : content.toCharArray()) {
            if(c == '{') {
                start++;
            }
            if(c == '}') {
                start--;
            }
            if(c == ',' && start == 0) {
                // 解析字段
                String filedStr = field.toString();
                CustomObj item = null;
                if(filedStr.startsWith("{")) {
                    item = parse(filedStr);
                } else if(!filedStr.trim().isEmpty()){
                    item = IntNode.parse(filedStr);
                }
                if(item != null) {
                    obj.add(item);
                }
                field = new StringBuilder();
                continue;
            }
            field.append(c);
        }
        if(field.length() > 0) {
            CustomObj item = parse(field.deleteCharAt(field.length() - 1).toString());
            if(item != null) {
                obj.add(item);
            }
        }
        return obj;
    }

    @Override
    public String toString() {
        return "CustomObj{" +
                "values=" + values +
                '}';
    }

    public String deserialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (CustomObj o : values) {
            sb.append(o.deserialize());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomObj obj = new CustomObj();
        obj.add(new IntNode(1));
        obj.add(new IntNode(2));

        CustomObj obj1 = new CustomObj();
        obj1.add(new IntNode(3));
        obj1.add(new IntNode(4));
        obj1.add(new IntNode(5));

        CustomObj obj2 = new CustomObj();
        obj2.add(new IntNode(6));

        CustomObj obj21 = new CustomObj();
        CustomObj obj211 = new CustomObj();
        obj211.add(new IntNode(7));
        obj211.add(new IntNode(8));
        obj21.add(obj211);
        obj2.add(obj21);
        obj1.add(obj2);
        obj.add(obj1);

        System.out.println(obj.deserialize());
        System.out.println(obj.toString());

        CustomObj po = CustomObj.parse("{1,2,{3,4,,,}}");
        System.out.println(po.deserialize());

        CustomObj po1 = CustomObj.parse("{1,2,{3,4},5}");
        System.out.println(po1.deserialize());

        CustomObj po2 = CustomObj.parse("{1,2,{3,4,5,{6,{{7,8}}}}}");
        System.out.println(po2.deserialize());
    }
}

class IntNode extends CustomObj {
    private int value;

    public IntNode() {}

    public IntNode(int value) {
        this.value = value;
    }

    protected static CustomObj parse(String str) {
        return new IntNode(Integer.parseInt(str));
    }

    @Override
    public String deserialize() {
        return "" + value;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                '}';
    }
}
