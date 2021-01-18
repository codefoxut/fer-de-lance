from simple.simple_pb2 import SimpleMesssage


simple_msg = SimpleMesssage()
simple_msg.id = 123
simple_msg.is_simple = True
simple_msg.name = "This is a simple Message"
simple_msg.sample_list = [1, 2, 3, 5]

print(simple_msg)