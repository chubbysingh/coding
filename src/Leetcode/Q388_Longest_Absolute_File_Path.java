package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q388_Longest_Absolute_File_Path {
    private class NodeFile {
        String name;
        List<NodeFile> list;
        int max = 0;

        public NodeFile(String name) {
            this.name = name;
            this.list = new ArrayList<NodeFile>();
            this.max = name.contains(".") ? name.length() : 0;
        }
    }

    public int lengthLongestPath(String input) {
        int max = 0;
        String[] strs = input.split("\n");
        StringBuffer sb = new StringBuffer(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].substring(0, 1).equals("\t") || (strs[i].length() > 4 && strs[i].substring(0, 4).equals("    "))) {
                sb.append('\n' + strs[i]);
            } else {
                NodeFile node = structureTreeFile(sb.toString());
                if (node.max > max) {
                    max = node.max;
                }
                sb = new StringBuffer(strs[i]);
            }
        }
        NodeFile node = structureTreeFile(sb.toString());
        if (node.max > max) {
            max = node.max;
        }
        return max;
    }

    public NodeFile structureTreeFile(String input) {
        if (input.length() > 0) {
            String[] strs = input.split("\n");
            StringBuffer sb = new StringBuffer();
            NodeFile ans = new NodeFile(strs[0]);
            int otherMax = 0;
            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];
                if (s.length() > 4 && s.substring(0, 4).equals("    ")) {
                    s = s.substring(4);
                } else {
                    s = s.substring(1);
                }
                if (s.contains("\t")) {
                    sb.append("\n" + s);
                } else {
                    NodeFile node = structureTreeFile(sb.toString());
                    if (node != null) {
                        ans.list.add(node);
                        if (node.max > otherMax) {
                            otherMax = node.max;
                        }
                    }
                    sb = new StringBuffer(s);
                }
            }
            NodeFile node = structureTreeFile(sb.toString());
            if (node != null) {
                ans.list.add(node);
                if (node.max > otherMax) {
                    otherMax = node.max;
                }
            }
            if (otherMax != 0) {
                ans.max = ans.name.length() + 1 + otherMax;
            }
            return ans;
        }
        return null;
    }
}
