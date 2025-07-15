import axios from 'axios';
import {useEffect, useState} from "react";

const Todo = () => {
    const [todos, setTodos] = useState<Todo[]>([]);

    useEffect(() => {getAllTodo()},[]);

     const getAllTodo=async()=>{
        try{
            const response =await axios.get<Todo[]>('http://localhost:8080')
            setTodos(response.data);
        }catch (error){
            console.log(error);
        }
    }


    return (
        <div>
          <h1>Danh sach to_do</h1>
            <ul>
                {todos.map((todo,i)=>(
                    <li key={i}>{todo.title}:{todo.description}
                    <span> [{todo.completed ? 'Hoàn thành' : 'chưa xong'}]</span>
                    </li>
                ))}
            </ul>
        </div>
    );
};

type Todo = {
    id: number;
    title: string;
    description: string;
    completed: boolean;
}


export default Todo;