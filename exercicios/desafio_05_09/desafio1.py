class Node:
    def __init__(self, data):
        self.data = data
        self.prev = self
        self.next = self

    def insert_after(self, data):
        new_node = Node(data)
        new_node.prev = self
        new_node.next = self.next
        self.next.prev = new_node
        self.next = new_node
        return new_node

    def delete(self):
        self.prev.next = self.next
        self.next.prev = self.prev
        return self.prev

    def print_list(self):
        current = self
        result = []
        while True:
            result.append(str(current.data))
            current = current.next
            if current == self:
                break
        print(" <-> ".join(result) + " <-> " + result[0])

class InsertNode(Node):
    def insert_after(self, data):
        new_node = super().insert_after(data)
        # Garante que o novo nó está circular
        if new_node.next != self:
            new_node.next.prev = new_node
            new_node.prev.next = new_node
        return new_node

class DeleteNode(Node):
    def delete(self):
        deleted_prev = super().delete()
        # Garante que a lista permanece circular após exclusão
        if deleted_prev.next == self:
            deleted_prev.next = deleted_prev
            deleted_prev.prev = deleted_prev
        return deleted_prev

class PrintNode(Node):
    def print_list(self):
        current = self
        result = []
        while True:
            result.append(str(current.data))
            current = current.next
            if current == self:
                break
        print(" <-> ".join(result) + " <-> " + result[0])

class ComboNode(InsertNode, DeleteNode, PrintNode):
    pass

# Teste
if __name__ == "__main__":
    node = ComboNode(1)
    new_node = node.insert_after(2)
    new_node.insert_after(3)
    node.print_list()  # Saída: 1 <-> 2 <-> 3 <-> 1
    
    new_node.insert_after(2.5)

    deleted_prev = new_node.delete()
    deleted_prev.print_list()  # Saída: 1 <-> 2.5 <-> 3 <-> 1