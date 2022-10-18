call plug#begin()
Plug 'arcticicestudio/nord-vim'
Plug 'dracula/vim', { 'as': 'dracula'}
Plug 'morhetz/gruvbox'
Plug 'ghifarit53/tokyonight-vim'
Plug 'vim-airline/vim-airline'
Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }
Plug 'jiangmiao/auto-pairs'
Plug 'nvim-treesitter/nvim-treesitter', {'do': ':TSUpdate'}
Plug 'iamcco/markdown-preview.nvim', { 'do': 'cd app && npm install' }

Plug 'neovim/nvim-lspconfig'
Plug 'lukas-reineke/lsp-format.nvim'

Plug 'hrsh7th/cmp-nvim-lsp'
Plug 'hrsh7th/cmp-buffer'
Plug 'hrsh7th/cmp-path'
Plug 'hrsh7th/cmp-cmdline'
Plug 'hrsh7th/nvim-cmp'
Plug 'hrsh7th/cmp-vsnip'
Plug 'hrsh7th/vim-vsnip'

Plug 'nvim-lua/plenary.nvim'
Plug 'nvim-telescope/telescope.nvim', { 'tag': '0.1.0' }
call plug#end()

colorscheme gruvbox

let g:airline_powerline_fonts = 1
let g:airline#extensions#tabline#enabled = 1
let g:airline#extensions#tabline#left_sep = ''
let g:airline#extensions#tabline#left_alt_sep = '|'
let g:airline#extensions#tabline#formatter = 'unique_tail'

set nu
set relativenumber
set scrolloff=5
set wrap

set encoding=utf-8
set fileencoding=utf-8

set ts=2 "tab-stop : number of spaces that <Tab> in file uses
set sts=2 "soft-tab-stop : number of spaces that <Tab> while editing
set sw=2 "shift-width : number of spasces to use for autoindent step

set cindent
set autoindent
set smartindent

set cursorline
set signcolumn=yes

set completeopt=menu,menuone,noselect

lua << EOF
vim.api.nvim_set_keymap('', '<space>', '<nop>', {noremap=true, silent=true})
vim.g.mapleader = " "

vim.api.nvim_set_keymap('n', '<leader>f', ':NERDTreeToggle<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>p', ':MarkdownPreviewToggle<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>h', ':bp<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>l', ':bn<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>w', ':bw<CR>', {noremap = true, silent=true})

vim.api.nvim_set_keymap('n', '<leader>tf', ':Telescope find_files<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>tg', ':Telescope live_grep<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>tb', ':Telescope buffers<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>th', ':Telescope help_tags<CR>', {noremap = true, silent=true})

vim.api.nvim_set_keymap('n', '<leader>do', '<cmd>lua vim.diagnostic.open_float()<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>dp', '<cmd>lua vim.diagnostic.goto_prev()<CR>', {noremap = true, silent=true})
vim.api.nvim_set_keymap('n', '<leader>dn', '<cmd>lua vim.diagnostic.goto_next()<CR>', {noremap = true, silent=true})
EOF

lua << EOF
-- Setup nvim-cmp.
local cmp = require'cmp'

cmp.setup({
	snippet = {
		-- REQUIRED - you must specify a snippet engine
		expand = function(args)
			vim.fn["vsnip#anonymous"](args.body) -- For `vsnip` users.
			-- require('luasnip').lsp_expand(args.body) -- For `luasnip` users.
			-- require('snippy').expand_snippet(args.body) -- For `snippy` users.
			-- vim.fn["UltiSnips#Anon"](args.body) -- For `ultisnips` users.
		end,
	},
	window = {
		-- completion = cmp.config.window.bordered(),
		-- documentation = cmp.config.window.bordered(),
	},
	mapping = cmp.mapping.preset.insert({
		['<C-b>'] = cmp.mapping.scroll_docs(-4),
		['<C-f>'] = cmp.mapping.scroll_docs(4),
		['<tab>'] = cmp.mapping.scroll_docs(4),
		['<C-Space>'] = cmp.mapping.complete(),
		['<C-e>'] = cmp.mapping.abort(),
		['<CR>'] = cmp.mapping.confirm({ select = true }), -- Accept currently selected item. Set `select` to `false` to only confirm explicitly selected items.
	}),
	sources = cmp.config.sources({
		{ name = 'nvim_lsp' },
		{ name = 'vsnip' }, -- For vsnip users.
		-- { name = 'luasnip' }, -- For luasnip users.
		-- { name = 'ultisnips' }, -- For ultisnips users.
		-- { name = 'snippy' }, -- For snippy users.
	}, {
		{ name = 'buffer' },
	})
})

-- Set configuration for specific filetype.
cmp.setup.filetype('gitcommit', {
	sources = cmp.config.sources({
		{ name = 'cmp_git' }, -- You can specify the `cmp_git` source if you were installed it.
	}, {
		{ name = 'buffer' },
	})
})

-- Use buffer source for `/` (if you enabled `native_menu`, this won't work anymore).
cmp.setup.cmdline('/', {
	mapping = cmp.mapping.preset.cmdline(),
	sources = {
		{ name = 'buffer' }
	}
})

-- Use cmdline & path source for ':' (if you enabled `native_menu`, this won't work anymore).
cmp.setup.cmdline(':', {
	mapping = cmp.mapping.preset.cmdline(),
	sources = cmp.config.sources({
		{ name = 'path' }
	}, {
		{ name = 'cmdline' }
	})
})

-- Setup lspconfig.
local capabilities = require('cmp_nvim_lsp').default_capabilities(vim.lsp.protocol.make_client_capabilities())
-- Replace <YOUR_LSP_SERVER> with each lsp server you've enabled.
require('lspconfig')['tsserver'].setup {
	capabilities = capabilities,
	single_file_support = true,
	handlers = {
		["textDocument/publishDiagnostics"] = vim.lsp.with(
		vim.lsp.diagnostic.on_publish_diagnostics, {
				update_in_insert = true,
			}
		)
	},
	on_attach = require "lsp-format".on_attach,
}
EOF
