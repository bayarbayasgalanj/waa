import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { Pageone, Pagetwo, Pagethree, Pagefour } from './pages';
import './App.css';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Pageone />
  },
  {
    path: "/pageone",
    element: <Pageone />
  },
  {
    path: "/pagetwo",
    element: <Pagetwo />
  },
  {
    path: "/pagethree",
    element: <Pagethree />
  },
  {
    path: "/pagefour",
    element: <Pagefour />
  }
]);

function App() {
  return (
    <div>
      <RouterProvider router={router} />
    </div>

  );
}

export default App;
