import React from 'react';
import { useParams } from 'react-router-dom';

function Results() {
  const { result } = useParams();

  return (
    <div>
      <h1>Result: {result}</h1>
    </div>
  );
}

export default Results;
