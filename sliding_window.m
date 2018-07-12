function sliding_window(input_file, window_size, output_file)
  data = csvread(input_file);
  particles = [1:rows(data)];
  i = 1;
  window_arr = [];
  while i + window_size - 1 < columns(particles)
    window_arr = [window_arr; particles(i), particles(i+window_size - 1), window_size / (data(i+window_size - 1) - data(i)) ];
    i += 1;
  endwhile
  % save output_file window_arr
  csvwrite(output_file, window_arr);
endfunction
