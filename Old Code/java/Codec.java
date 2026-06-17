import java.util.*;

class Codec {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        dfsSerialize(root, sb);

        return sb.toString();
    }

    private void dfsSerialize(TreeNode node,
                              StringBuilder sb) {

        if (node == null) {

            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {

        Queue<String> queue =
                new LinkedList<>(
                        Arrays.asList(data.split(","))
                );

        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(
            Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode node =
                new TreeNode(Integer.parseInt(value));

        node.left = dfsDeserialize(queue);
        node.right = dfsDeserialize(queue);

        return node;
    }
}
