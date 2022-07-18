call plug#begin()
	Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }
	Plug 'dracula/vim', { 'as': 'dracula' }
	Plug 'vim-airline/vim-airline'
call plug#end()

set nu
set relativenumber
set scrolloff=5
set nowrap
set cursorline

set ts=4 "tab-stop : number of spaces that <Tab> in file uses
set sts=4 "soft-tab-stop : number of spaces that <Tab> while editing
set sw=4 "shift-width : number of spasces to use for autoindent step

set cindent
set autoindent
set smartindent

set incsearch
set hlsearch

colorscheme dracula

let g:airline_powerline_fonts = 1
let g:airline#extensions#tabline#enabled = 1
let g:airline#extensions#tabline#left_sep = ''
let g:airline#extensions#tabline#left_alt_sep = '|'
let g:airline#extensions#tabline#formatter = 'unique_tail'
let g:airline#extensions#tabline#fnamemod = ':t'

nnoremap <SPACE> <Nop>
let mapleader=" "

nmap <Leader>f :NERDTreeToggle<CR>
nmap <Leader>h :bp<CR>
nmap <Leader>l :bn<CR>
nmap <Leader>w :bw<CR>
