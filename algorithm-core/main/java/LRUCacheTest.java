import java.util.Hashtable;
import java.util.LinkedHashMap;

/** LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例：
 * LRUCache cache = new LRUCache( 2 -- 缓存容量)
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

// 双向链表 + 哈希表
class LRUCache {
    private Hashtable<Integer, DoubleLinkedNode> cache = new Hashtable();
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;

    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }

    // 总是往头部插(可以保证插入的时候是最新元素)
    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 设置head和tail(伪头部和伪尾部标记界限)，在更新的时候就不需要检查是否是null节点
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node==null) return -1;
        // 保证刚访问过的元素
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node==null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if (size > capacity) {
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

