from fastapi import FastAPI
from models import Todo

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello world"}


todos = []


# Get all todos
@app.get("/todos/")
async def get_todos():
    return {"todos": todos}


# Get single todo
@app.get("/todos/{todo_id}")
async def get_todo(todo_id: int):
    for t in todos:
        if t.id == todo_id:
            return {"todo": t}
    return {"message": "No todo found"}


# Create a todo
@app.post("/todos/")
async def create_todos(todo: Todo):
    todos.append(todo)
    return {"message": "Todo has been added"}


# Update a todo
@app.put("/todos/")
async def update_todo(todo: Todo):
    for t in todos:
        if t.id == todo.id:
            t.item = todo.item
            return {"todo": todo}
    return {"message": "No todo found"}


# Delete a todo
@app.delete("/todos/{todo_id}")
async def del_todo(todo_id: int):
    for t in todos:
        if t.id == todo_id:
            todos.remove(t)
            return {"todo": t}
    return {"message": "No todo found"}
