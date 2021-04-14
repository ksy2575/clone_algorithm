# Trie 구현
class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = {}


class Trie(object):
    def __init__(self):
        self.head = Node(None)

    # insert
    def insert(self, string):
        curr_node = self.head

        for char in string:
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)

            curr_node = curr_node.children[char]
        curr_node.data = string

    def search(self, string):
        curr_node = self.head
        for char in string:
            if char in curr_node.children:
                curr_node = curr_node.children[char]
                print(curr_node.key)
            else:
                return False
        if curr_node.data != None:
            return True
        else:
            return False


# start_node = Trie()
# start_node.insert('abc')
# start_node.insert('a')
# print(start_node.search('abc'))
# print(start_node.search('ab'))