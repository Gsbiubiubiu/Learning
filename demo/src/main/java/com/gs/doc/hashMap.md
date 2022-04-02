# 1.红黑树分析及Hashmap源码分析

#### 1.1 红黑树定义

```
1.每个节点或是红的，或是黑的
2.根节点是黑色的
3.每个叶子节点是黑色的
4.如果一个节点是红色的，那么它的两个儿子都是黑色的
5.对每个节点，从该节点到其子孙节点的所有路径上包含相同数目的黑节点

插入节点：
父节点是黑色的， 不用进行调整
父节点是红色：
	（1）叔叔是空的，旋转+变色
	（2）叔叔是红色，父节点+叔叔节点变黑色，祖父节点变为红色
	（3）叔叔是黑色，旋转+变色
	其实1与3一致
	
```

#### 1.2 Hashmap源码

```java
// put方法调用了 putVal
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }


final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }


// HashMap中的红黑树 
static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }
// op: 定义的属性有 父节点parent 左节点left 右节点right prev??? 颜色 boolean   
```

#### 1.3 让红黑树插入平衡的方法 balanceInsertion()

```java
// 红黑树加入节点后让 树平衡的方法
// 参数中root为根节点， x为新插入的元素
static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
                                                    TreeNode<K,V> x) {
            x.red = true; //定义 新插入节点都为红色
  // xp标识x的父节点，xpp标识x的祖父节点，xppl标识xpp的左孩子节点，xppr标识xpp的右孩子节点
   // 定义了这三个变量 然后死循环
            for (TreeNode<K,V> xp, xpp, xppl, xppr;;) {
    //把新增节点x的父节点赋给xp (x.parent在此方法前有定义) 如果x的父节点为空  
    // 说明此时新增节点就为根节点
                if ((xp = x.parent) == null) {  
                    x.red = false; // 根节点需为黑色 将颜色变黑
                    return x;	// 方法结束 不需要调整了 此时x就为root 返回
                }
     // 父节点如果是黑色的 || 父节点的父节点 也就是xpp祖父节点为空 
     // 也就是说x插入到了根节点下 此时也不需要调整（黑色下增加红色符合定义）
                else if (!xp.red || (xpp = xp.parent) == null)
                    return root; // 返回根节点 跳出循环
      // 新增节点插入在祖父节点的左孩子节点上
      //          xpp
      //         /  \
      //     xppl/xp  xppr
      //       /
      //      x        
                if (xp == (xppl = xpp.left)) {
                    // xppr 祖父节点的右孩子不为空且颜色为红色(叔叔节点 因为此时是挂在左节点上)
                    // 同时父节点也是红色(如果是黑色就走到了上面的判断逻辑中)
                    // 此时满足上面的（2）叔叔是红色，父节点+叔叔节点变黑色，祖父节点变为红色
                    if ((xppr = xpp.right) != null && xppr.red) {
                        xppr.red = false; //叔叔节点变黑色
                        xp.red = false;	  //父节点变黑色
                        xpp.red = true;	  // 祖父节点变红色
                        x = xpp;	// 进行递归 在向上判断有没有影响别的分支结构
                    }
                    else {  // 叔叔节点为空 或者叔叔节点为黑色 eg:此时叔叔节点只能为null 因为父节点已经是红 不然不符合平衡
      //          xpp
      //         /  \
      //     xppl/xp  
      //         \
      //          x     这种情况  需要经过两次旋转(先左旋为下面的样子 再右旋)
                        if (x == xp.right) {
                            root = rotateLeft(root, x = xp);
                            //此时旋转为了
                        //    xpp     ---> 赋值条件 x=xp  xpp    xp = x.parent           xpp(其实是回归原顺序)
                       //    /                          /  (x为原xp所以parent为原来x)     /
                      //    x                         xp                              xp
                     //   /                          /                                /
                    //  xp                         xp                                x
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
      //          xpp
      //         /  \
      //     xppl/xp  
      //        /
      //       x        这种情况一次旋转就可以了          
                        if (xp != null) {
                            xp.red = false;      // 变色
                            if (xpp != null) {
                                xpp.red = true;  // 变色 一黑带两红
                                root = rotateRight(root, xpp);
                            }
                        }
                    }
                }
                
      //      xpp  --->       xpp  -->           xp
      //       \   右旋(xp)     \   左旋(xpp)     / \ 
      //        xp              xp             xpp  x
      //       /                 \  
      //      x                   x 
                else {  // 新增节点插入在祖父节点的左孩子节点上 将左换成右
                    if (xppl != null && xppl.red) {
                        xppl.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    }
                    else {
                        if (x == xp.left) {
                            root = rotateRight(root, x = xp);
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = rotateLeft(root, xpp);
                            }
                        }
                    }
                }
            }
        }
```

#### 1.4 红黑树左旋代码 rotateLeft()

```java
// 红黑树左旋代码 
// 根据前提条件 此时进来时红黑树的形状为
// 
      //          xpp
      //         /  \
      //     xppl/xp  
      //         \
      //          x     这种情况  需要经过两次旋转(先左旋为下面的样子 再右旋)
// (1)if  判断的情况为
//         xpp   (判断条件变为了这种情况)
//        /
//       p
//        \
//         r

// (2)if  判断的情况为
//         xpp                         ---->                 xpp(指向暂时没变 还是p)   
//        /                                                  
//       p                                                  r
//        \                                                /
//         r                                              p  
//        /                                                \
//       rl      (此时如果左旋的话需要对rl做处理)               rl  

//(3)if 判断的情况
// 赋值条件里 r.parent = p.parent是进行左旋
//    xpp       ---->     pp     如果pp为空 即 --->    r  此时r为根节点 所以要变颜色为黑色
//    /                   /                         /
//   p                   r                         p
//    \                 /
//    r                p

// 疑问: 在条件判断里赋值  如果在(2)情况中 r.left为空 那p.right不就为空了 但其实p要旋转到最下面的 p.right为空本来就是正常情况的

//(4)if 判断的情况
//   pp的左孩子指向p (此时r的父亲指向pp， 但pp的指向还没变化 仍是p)
//   
static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root,
                                              TreeNode<K,V> p) {
            TreeNode<K,V> r, pp, rl;
       (1) if (p != null && (r = p.right) != null) {
       (2)      if ((rl = p.right = r.left) != null)
                    rl.parent = p;  // rl的父节点指向p同时p的右孩子节点指向 rl(判断条件中赋的值)
       (3)      if ((pp = r.parent = p.parent) == null)
                    (root = r).red = false;  // 变颜色
       (4)      else if (pp.left == p)
                    pp.left = r;  //此时r 与 pp互相指向
                else  //相反情况
                    pp.right = r;
                r.left = p;
                p.parent = r;
            }
            return root;
        }
```

#### 1.5 红黑树右旋代码 rotateRight()

```java
// 和左旋对称 这里就不分析了
static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root,
                                               TreeNode<K,V> p) {
            TreeNode<K,V> l, pp, lr;
            if (p != null && (l = p.left) != null) {
                if ((lr = p.left = l.right) != null)
                    lr.parent = p;
                if ((pp = l.parent = p.parent) == null)
                    (root = l).red = false;
                else if (pp.right == p)
                    pp.right = l;
                else
                    pp.left = l;
                l.right = p;
                p.parent = l;
            }
            return root;
        }
```

#### 2.1 hashmap put()

```java
// 调用 putval hash(key)
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }


// hash方法
// TODO 待补充
static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;  //  resize()初始化
        if ((p = tab[i = (n - 1) & hash]) == null) // 计算出数组下标
            tab[i] = newNode(hash, key, value, null); // 如果该数组为空 new 一个Node 放进去
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;        // 如果key相等的话 直接覆盖 如果不相等 说明此时是一个链表或红黑树 且不是第一个元素
            else if (p instanceof TreeNode)  
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else { // 遍历链表的操作
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) { //说明链表已经遍历完了 没有找到相同的就新增
                        p.next = newNode(hash, key, value, null); // 尾插法
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);   // 大于等于8的话就转树
                        break;
                    }
                    if (e.hash == hash &&   
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;   // 找到了了相同key的元素 跳出循环
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key  //覆盖元素
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e); //linkhashmap方法 这里为空
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)  // 扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

#### 2.2 树化方法 treeifyBin()

```java
// 传进来的是当前链表数组 和 hash值
final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY) // 数组为空或者长度<64
            resize(); // 扩容 初始化  也可以使链表散列 增加查询效率
        else if ((e = tab[index = (n - 1) & hash]) != null) { //判断这个位置上是不是为空
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);// 此方法new了一个TreeNode
                if (tl == null)  //只有在首个元素时才会进入这个方法 所以hd始终为首位元素
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null); // 给每一个树节点与上一个树节点提供双向关系 
            if ((tab[index] = hd) != null) // 最后一个元素不等于空
                hd.treeify(tab); // 真正的树化方法
        }
    }
```

#### 2.3 树化方法 treeify()

```java
// 是TreeNode类的方法
// 调用的是node数组中首位元素的treeify()方法，传入的参数是整个node数组
// 思想就是 通过这个链表的首位元素 遍历这个链表 放入红黑树
final void treeify(Node<K,V>[] tab) {
            TreeNode<K,V> root = null;
            for (TreeNode<K,V> x = this, next; x != null; x = next) {  //遍历链表 放入红黑树
                next = (TreeNode<K,V>)x.next;  
                x.left = x.right = null;
                if (root == null) {   // 放入的是首个元素也就是根节点
                    x.parent = null;
                    x.red = false;
                    root = x;
                }
                else {  // 判断新节点应该插入到哪个位置上   p为红黑树根节点 x为要插入的元素
                    K k = x.key; // 拿到该元素的k值
                    int h = x.hash;
                    Class<?> kc = null; // 类型
                    for (TreeNode<K,V> p = root;;) { // 从根节点开始 
                        int dir, ph;
                        K pk = p.key; // pk = 根节点的k值
                        if ((ph = p.hash) > h) // ph = 根节点的hash值 大于 插入值的hash值
                            dir = -1; // 说明放到左边
                        else if (ph < h)
                            dir = 1;  // 说明放到右边
                        else if ((kc == null &&
                                  (kc = comparableClassFor(k)) == null) ||
                                 (dir = compareComparables(kc, k, pk)) == 0)
                            //hash值相同的话 通过上面的判断逻辑 有没有实现compare接口 返回实现类型
                            // 如果通过compare接口比较k也分不出大小的话会走下面这个方法
                            dir = tieBreakOrder(k, pk);
                        	// 这个方法先用compare比较classname getClass().getName()
                            // 在比较k的 System.identityHashcode()

                        TreeNode<K,V> xp = p; // p = p的孩子 直到为空也就是遍历当前红黑树看放哪
                        if ((p = (dir <= 0) ? p.left : p.right) == null) { 
                            x.parent = xp;
                            if (dir <= 0)
                                xp.left = x; // 放左
                            else
                                xp.right = x; // 放右
                            root = balanceInsertion(root, x); // 调整插入平衡
                            break;
                        }
                    }
                }
            }
    		// 把转化生成的红黑树 赋到本来链表的位置 tab[index]
            // 转成红黑树的时候本来是 单向链表->双向链表->红黑树
    		// 此时next prev指针都还在  但此时红黑树的root节点元素 并不一定是双向链表中的第一个元素
    		// 这个操作就是把root移动到双向链表的第一个元素
    		// 我猜测可能是因为 双向链表移动方便 后面如果退化成链表容易操作 并容易删除
            moveRootToFront(tab, root);
        }
```

#### 2.4 hashMap 扩容方法 resize()

```java
final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;  // oldTab为当前 table
        int oldCap = (oldTab == null) ? 0 : oldTab.length; // oldCap为当前table的长度
        int oldThr = threshold; // 旧的阈值
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) { //如果数组长度已经是最大值了 修改阈值返回
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY) //2倍之后在最大和默认之间的话
                newThr = oldThr << 1; // double threshold  // 阈值乘2
        }
    	// 说明上面的if并没有成立 oldCap <= 0 容量就等于旧的阈值
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; // 开始创建新数组转移
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {  //遍历数组
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) // 这个数组位置上只有一个元素 计算新的下标放进去
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode) // 红黑树扩容
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order  // 链表
                        Node<K,V> loHead = null, loTail = null; 
                        Node<K,V> hiHead = null, hiTail = null; //定义了两个链表用来存放
                        Node<K,V> next;
                        // 循环这个链表
                        do {
                            next = e.next;
                            // 为什么要用这个判断？
                            // oldCap为之前的长度 一定是2的幂次方 反应在二进制中
                            // 0000 1000 类似于这种 只会有一位是1
                            // 所以与hash值取余  就是看这一位上的hash是1还是0 别的位置上一定是0
                            // 所以最终只会有两个结果
                            // 将 0 的放入 loHead链表  将剩下的放入hiHead链表
                            // 就相当于将原链表 随机分成了两个链表
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead; // 放到原位置上
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead; //扩容了两倍 放到第二个的原位置上
                        }
                    }
                }
            }
        }
        return newTab;
    }
```

#### 2.5 红黑树扩容 split()

```java
// TreeNode里的方法 
// 传入的参数为 当前hashmap，新table，当前下标i，旧数组的长度

final void split(HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
            TreeNode<K,V> b = this;
            // Relink into lo and hi lists, preserving order
            TreeNode<K,V> loHead = null, loTail = null; 
            TreeNode<K,V> hiHead = null, hiTail = null; //定义了两个红黑树
            int lc = 0, hc = 0;
            for (TreeNode<K,V> e = b, next; e != null; e = next) { //遍历这个链表
                // 因为此时红黑树也是双向链表 有next指针
                next = (TreeNode<K,V>)e.next;
                e.next = null;
                if ((e.hash & bit) == 0) {
                    if ((e.prev = loTail) == null)
                        loHead = e;
                    else
                        loTail.next = e;
                    loTail = e;
                    ++lc;  // 与前面遍历链表的逻辑相同 只是会进行计数
                }
                else {
                    if ((e.prev = hiTail) == null)
                        hiHead = e;
                    else
                        hiTail.next = e;
                    hiTail = e;
                    ++hc;
                }
            }

            if (loHead != null) {
                if (lc <= UNTREEIFY_THRESHOLD) // 个数小于6
                    // 此时还是一个TreeNode节点 调用这个方法 遍历 new Node节点给一个单向链表返回
                    tab[index] = loHead.untreeify(map); // 
                else {
                    tab[index] = loHead;
                    // 如果另一个链表为空 说明并不散列 此时的loHead就是原来的红黑树所以直接赋值就好了
                    // 如果不为空 说明他已经分割成两个链表了 所以需要重新树化
                    if (hiHead != null) // (else is already treeified) 
                        loHead.treeify(tab);
                }
            }
            if (hiHead != null) {
                if (hc <= UNTREEIFY_THRESHOLD)
                    tab[index + bit] = hiHead.untreeify(map);
                else {
                    tab[index + bit] = hiHead;
                    if (loHead != null)
                        hiHead.treeify(tab);
                }
            }
        }
```

#### 2.6 hashMap的 get()方法 待添加注释

```java
public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

#### 2.7 hashMap remove() 方法  待补充