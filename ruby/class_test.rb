class MegaGreeter
    attr_accessor :names

    def initialize(names = "World")
        @names = names
    end

    def hello
        if @names.nil?
            puts "..."
        
        elsif @names.respond_to?("each")
            @names.each do |name|
                puts "Hello #{name}!"
            end
        else
            puts "Hello #{@names}!"
        end
    end

    def bye
        if @names.nil?
            puts "..."
        
        elsif @names.respond_to?("join")
            puts "Goodbye #{@names.join(", ")}. come back soon!"
        else
            puts "Goodbye #{@names}!"
        end
    end

end

if __FILE__ == $0
    mg = MegaGreeter.new
    mg.hello
    mg.bye

    mg.names="zeke"
    mg.hello
    mg.bye

    mg.names = ["albert", "brenda", "charles"]
    mg.hello
    mg.bye

    mg.names = nil
    mg.hello
    mg.bye
end