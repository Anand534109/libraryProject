
import { useEffect, useState } from "react";

function OpenLibrary() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/Library/search?q=hindi")
      .then(res => res.json())
      .then(data => setBooks(data.docs || []));
  }, []);

  console.log(books);

  return (
    <div>
      {books.map((b, i) => (
        <div key={i}>
          <h3>{b.title}</h3>
          <p>{b.author_name?.[0]}</p>
          <h1>{b.cover_i}</h1>

          {b.cover_i && (
            <img
              src={`https://covers.openlibrary.org/b/id/${b.cover_i}-M.jpg`}
              alt="book"
            />
          )}
        </div>
      ))}
      {/* <iframe
        src="https://openlibrary.org/works/OL308980W"
        width="100%"
        height="600px"
      /> */}
    </div>
  );
}

export default OpenLibrary;