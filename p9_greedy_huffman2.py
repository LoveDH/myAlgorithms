class Queue(object):

    def __init__(self):
        self._q = []

    def put(self, x):
        self._q.append(x)
        self._q.sort(key = lambda x: x[0])
    
    def get(self):
        x = self._q[0]
        del self._q[0]
        return x

    def qsize(self):
        return len(self._q)

class HuffmanNode(object):
    
    def __init__(self, left, right):
        self.left = left
        self.right = right

freq = [
    (4, 'a'), (3, 'b'), (3, 'c'), (4, 'd'),
     ]


def create_tree(frequencies):
    p = Queue()
    for value in frequencies:
        p.put(value)
    while p.qsize() > 1:
        l, r = p.get(), p.get()
        node = HuffmanNode(l, r)
        p.put((l[0]+r[0], node))
    return p.get()

node = create_tree(freq)

def side_by_side(a, b, w):
    a = a.split('\n')
    b = b.split('\n')
    n1 = len(a)
    n2 = len(b)
    if n1 < n2:
        a.extend([" "*len(a[0])] * (n2 - n1))
    else:
        b.extend([" "*len(b[0])] * (n1 - n2))
    r = [" "*len(a[0]) + "   ^   " + " "*len(b[0])]
    r += ["/" + "-"*(len(a[0])-1) + "%7.3f" % w + "-"*(len(b[0])-1) + "\\"]
    for l1, l2 in zip(a,b):
        r.append(l1 + "       " + l2)
    return "\n".join(r)

def print_tree(node):
    w, n = node
    if isinstance(n, str):
        return "%s = %.3f" % (n, w)
    else:
        l = print_tree(n.left)
        r = print_tree(n.right)
        return side_by_side(l, r, w)

print(print_tree(node))

def walk_tree(node, prefix = "", code = {}):
    w, n = node
    if isinstance(n, str):
        code[n] = prefix
    else:
        walk_tree(n.left, prefix + '0')
        walk_tree(n.right, prefix + '1')
    return code

code = walk_tree(node)
for i in sorted(freq, reverse=True):
    print(i[1], '{:6.2f}'.format(i[0]), code[i[1]])