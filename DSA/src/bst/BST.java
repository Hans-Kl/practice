package bst;

/**
 * <算法>书中的二叉搜索树实现,P252
 *
 * <p>2020/11/6 14:37
 *
 * @author konglinghan
 * @version 1.0
 */
public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) return 0;
    else return x.N;
  }

  /**
   * 根据key检索value值,递归实现
   *
   * @param key
   * @return
   */
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) return null;
    int cmp = node.key.compareTo(key);
    if (cmp < 0) return get(node.left, key);
    else if (cmp > 0) return get(node.right, key);
    else return node.value;
  }

  public void put(Key key, Value value) {}

  private void put(Node node, Key key, Value value) {}

  private class Node {
    private Key key;
    private Value value;
    private Node left, right;
    private int N;

    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }
}
