# 프로그래머스 가사 검색 -> Trie로 구현하였으나 효율성 4, 5번 테스트 실패
from collections import defaultdict
class Node(object):
    def __init__(self, key, length=None, data=None):
        self.key = key
        self.data = data
        self.children = {}
        self.length = defaultdict(int)


class Trie(object):
    def __init__(self):
        self.head = Node(None)

    # insert
    def insert(self, string):
        curr_node = self.head
        length = len(string)
        for char in string:
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)

            curr_node.length[length] += 1
            length -= 1
            curr_node = curr_node.children[char]
        curr_node.data = string

    def search(self, string):
        curr_node = self.head
        for i in range(len(string)):
            char = string[i]
            # print(char)
            if char in curr_node.children:
                curr_node = curr_node.children[char]
            else:
                if char == '?':
                    return curr_node.length[len(string) - i]
                else:
                    return 0


def solution(words, queries):
    answer = []
    front_trie = [Trie() for _ in range(10002)]
    end_trie = [Trie() for _ in range(10002)]
    for word in words:
        front_trie[len(word)].insert(word)
        end_trie[len(word)].insert(word[::-1])
    for query in queries:
        if query[0] != '?':
            answer.append(front_trie[len(query)].search(query))
        else:
            answer.append(end_trie[len(query)].search(query[::-1]))

    return answer
# print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?", "?????", '????p']))